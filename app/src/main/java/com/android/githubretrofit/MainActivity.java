package com.android.githubretrofit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.githubretrofit.controllers.GitHubUserController;
import com.android.githubretrofit.database.loaders.UserLoader;
import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.ui.SimpleDividerItemDecoration;
import com.android.githubretrofit.ui.adapters.UserListAdapter;
import com.android.githubretrofit.util.Dialogs;
import com.orm.SugarRecord;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.android.githubretrofit.util.Logger.log;

/**
 * {@author equa1s}
 */
public class MainActivity
        extends AppCompatActivity
        implements GitHubUserController.GitHubUserCallbackListener,
            LoaderManager.LoaderCallbacks<List<User>> {

    private static final String TAG = MainActivity.class.getSimpleName();

    private UserListAdapter mUserListAdapter = null;
    private GitHubUserController mUserController;

    @BindView(R.id.users_recycler_view) public RecyclerView mRecyclerView;

    public MainActivity() {
        this.mUserController = new GitHubUserController(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        initLoader();

        initRecyclerView();

    }

    private void initRecyclerView() {

        mUserListAdapter = new UserListAdapter(this, new ArrayList<User>());

        if (mRecyclerView != null) {

            mRecyclerView.setHasFixedSize(true);

            LinearLayoutManager llm = new LinearLayoutManager(this);
                llm.setOrientation(LinearLayoutManager.VERTICAL);

            mRecyclerView.setLayoutManager(llm);
            mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
            mRecyclerView.setAdapter(mUserListAdapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem search = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    mUserController.getUser(query);
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_flash:
                Dialogs.newInstance().setOnClickListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SugarRecord.deleteAll(User.class);
                        restartLoader();
                    }
                }).showAlertDialog(this, getString(R.string.dialog_alert_title), getString(R.string.dialog_alert_message));
                return true;

            default:
                return false;
        }
    }

    @Override
    public void onSuccess(User user) {
        SugarRecord.save(user);
        restartLoader();
        log(TAG, "User: " + user.getLogin().toUpperCase() + " has been saved.");
    }

    @Override
    public void onFailure(Throwable t) {
        String err = t.getMessage();
        log(TAG, err);
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinish() {
        log(TAG, "Request complete.");
    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {
        return new UserLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<User>> loader, List<User> data) {
        log(TAG, "Data loaded: " + Arrays.toString(data.toArray()));
        mUserListAdapter.swap(data);
    }

    @Override
    public void onLoaderReset(Loader<List<User>> loader) {
        log(TAG, "Loader has been reset.");
    }

    private void initLoader() {
        getSupportLoaderManager().initLoader(UserLoader.USER_LOADER_ID, null, this).forceLoad();
    }

    private void restartLoader() {
        getSupportLoaderManager().restartLoader(UserLoader.USER_LOADER_ID, null, this).forceLoad();
    }
}

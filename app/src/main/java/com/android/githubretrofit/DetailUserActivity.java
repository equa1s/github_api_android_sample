package com.android.githubretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.githubretrofit.controllers.GitHubApiController;
import com.android.githubretrofit.controllers.callbacks.GitHubRepositoriesCallback;
import com.android.githubretrofit.database.model.Repository;
import com.android.githubretrofit.database.model.User;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.android.githubretrofit.util.Logger.log;

/**
 * {@author equa1s}
 */
public class DetailUserActivity extends AppCompatActivity implements GitHubRepositoriesCallback {

    public static final String USER_DATA = "user_data";
    private static final String TAG = DetailUserActivity.class.getSimpleName();

    private User mUser = null;
    private GitHubApiController mGitHubApiController = null;

    @BindView(R.id.avatar) public CircleImageView mUserAvatar;
    @BindView(R.id.login) public TextView mLogin;
    @BindView(R.id.created_at) public TextView mCreatedAt;

    public DetailUserActivity() {
        mGitHubApiController = new GitHubApiController(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_datails_layout);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUser = bundle.getParcelable(USER_DATA);
        }

        if (mUser != null) {
            setUserData();
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setTitle(mUser.getLogin() + ":" + mUser.getGithubId());
            }
            mGitHubApiController.getUserRepositories(mUser.getLogin());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: super.onBackPressed(); return true;
            default:return false;
        }
    }

    @Override
    public void onSuccess(List<Repository> repositories) {
        log(TAG, "User repositories: " + repositories.toString());
    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    @Override
    public void onFinish() {

    }

    private void setUserData() {
        loadAvatar();
        mLogin.setText(mUser.getLogin());
        mCreatedAt.setText(mUser.getCreatedAt());
    }

    private void loadAvatar() {
        Glide.with(this).load(mUser.getAvatarUrl()).into(mUserAvatar);
    }
}

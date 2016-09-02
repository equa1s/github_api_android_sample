package com.android.githubretrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.githubretrofit.database.model.User;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.android.githubretrofit.util.Logger.log;

/**
 * {@author equa1s}
 */
public class DetailUserActivity extends AppCompatActivity {

    private static final String TAG = DetailUserActivity.class.getSimpleName();

    public static final String USER_DATA = "user_data";

    private User mUser = null;

    @BindView(R.id.user_name) public TextView mUserName;
    @BindView(R.id.user_avatar) public CircleImageView mUserAvatar;
    @BindView(R.id.user_id) public TextView mUserId;
    @BindView(R.id.user_company) public TextView mUserCompany;
    @BindView(R.id.user_location) public TextView mUserLocation;
    @BindView(R.id.user_email) public TextView mUserEmail;

    public DetailUserActivity() {
        log(TAG, "construct");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details_layout);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mUser = bundle.getParcelable(USER_DATA);
        }

        if (mUser != null) {
            setUserData();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: super.onBackPressed(); return true;
            default:return false;
        }
    }

    private void setUserData() {
        loadAvatar();
        mUserId.setText(String.valueOf(mUser.getGithubId()));

        String location = mUser.getLocation();
        if (location != null && !location.isEmpty())
            mUserLocation.setText(location);
        else
            mUserLocation.setText("- / -");

        String company = mUser.getCompany();
        if (company != null && !company.isEmpty())
            mUserCompany.setText(company);
        else
            mUserCompany.setText("- / -");

        String email = mUser.getEmail();
        if (email != null && !email.isEmpty())
            mUserEmail.setText(email);
        else
            mUserEmail.setText("- / -");

        String username = mUser.getLogin();
        if (username != null && !username.isEmpty())
            mUserName.setText(username);
        else
            mUserName.setText("- / -");

    }

    private void loadAvatar() {
        Glide.with(this).load(mUser.getAvatarUrl()).into(mUserAvatar);
    }
}

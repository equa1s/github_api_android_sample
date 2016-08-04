package com.android.githubretrofit.api;

import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.util.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * {@author equa1s}
 */
public interface GitHubService {
    @GET(Constants.GitHubApi.USERS_ENDPOINT + "{user}")
    Call<User> getUser(@Path("user") String user);
}

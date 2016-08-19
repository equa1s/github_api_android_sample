package com.android.githubretrofit.api;

import com.android.githubretrofit.database.model.Repository;
import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * {@author equa1s}
 *
 * TODO : Add next methods
 * 1. https://api.github.com/users/{user}/followers (get followers of current acc)
 * 2. https://api.github.com/users/{user}/following (get following users)
 * 3. https://api.github.com/users/{user}/starred (get starred repositories of current acc)
 */
public interface GitHubService {

    @GET(Constants.GitHubApi.USERS_ENDPOINT + Constants.Url.PAT_SEPARATOR + "{user}")
    Call<User> getUser(@Path("user") String user);

    @GET(Constants.GitHubApi.USERS_ENDPOINT + Constants.Url.PAT_SEPARATOR + "{user}" + Constants.Url.PAT_SEPARATOR + Constants.GitHubApi.REPOSITORIES_ENDPOINT)
    Call<List<Repository>> getRepositories(@Path("user") String user);

}

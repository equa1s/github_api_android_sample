package com.android.githubretrofit.controllers;


import com.android.githubretrofit.api.GitHubService;
import com.android.githubretrofit.controllers.callbacks.GitHubCallback;
import com.android.githubretrofit.controllers.callbacks.GitHubRepositoriesCallback;
import com.android.githubretrofit.controllers.callbacks.GitHubUserCallback;
import com.android.githubretrofit.database.model.Repository;
import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.exceptions.EmptyRepositoryException;
import com.android.githubretrofit.exceptions.UserNotFoundException;
import com.android.githubretrofit.util.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * {@author equa1s}
 */
public class GitHubApiController {

    private GitHubService mGitHubService;
    private GitHubCallback mGitHubCallback;

    public GitHubApiController(GitHubCallback mGitHubCallback) {

        this.mGitHubCallback = mGitHubCallback;

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.GitHubApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mGitHubService = mRetrofit.create(GitHubService.class);

    }

    public void getUser(final String name) {
        Call<User> callback = mGitHubService.getUser(name);
            callback.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    User user = response.body();

                    if (user != null)
                        ((GitHubUserCallback) mGitHubCallback).onSuccess(user);
                    else
                        ((GitHubUserCallback) mGitHubCallback).onFailure(new UserNotFoundException("User: " + name +" doesn't exist!"));

                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    ((GitHubUserCallback) mGitHubCallback).onFailure(t);
                }
            });

        ((GitHubUserCallback) mGitHubCallback).onFinish();

    }

    public void getUserRepositories(final String name) {
        Call<List<Repository>> callback = mGitHubService.getRepositories(name);
            callback.enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {

                    List<Repository> repositories = response.body();

                    if (repositories != null) {
                        if (!repositories.isEmpty()) {
                            ((GitHubRepositoriesCallback) mGitHubCallback).onSuccess(repositories);
                        } else {
                            ((GitHubRepositoriesCallback) mGitHubCallback).onFailure(new EmptyRepositoryException("Repository is empty."));
                        }
                    } else {
                        ((GitHubRepositoriesCallback) mGitHubCallback).onFailure(new NullPointerException("List 'repositories' is NULL."));
                    }

                }

                @Override
                public void onFailure(Call<List<Repository>> call, Throwable t) {
                    ((GitHubRepositoriesCallback) mGitHubCallback).onFailure(new Exception());
                }
            });

        ((GitHubRepositoriesCallback) mGitHubCallback).onFinish();

    }

}

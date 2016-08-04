package com.android.githubretrofit.controllers;

import com.android.githubretrofit.api.GitHubService;
import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * {@author equa1s}
 */
public class GitHubUserController {

    private GitHubService mGitHubService;
    private GitHubUserCallbackListener mUserCallbackListener;

    public GitHubUserController(GitHubUserCallbackListener mUserCallbackListener) {

        this.mUserCallbackListener = mUserCallbackListener;

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
                    mUserCallbackListener.onSuccess(user);
                else
                    mUserCallbackListener.onFailure(new NullPointerException("User: " + name +" doesn't exist!"));

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mUserCallbackListener.onFailure(t);
            }
        });

        mUserCallbackListener.onFinish();

    }

    public interface GitHubUserCallbackListener {
        void onSuccess(User user);
        void onFailure(Throwable t);
        void onFinish();
    }

}

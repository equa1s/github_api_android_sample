package com.android.githubretrofit.controllers.callbacks;

import com.android.githubretrofit.database.model.Repository;

import java.util.List;

/**
 * {@author equa1s}
 */
public interface GitHubRepositoriesCallback extends GitHubCallback {
    void onSuccess(List<Repository> repositories);
    void onFailure(Throwable throwable);
    void onFinish();
}

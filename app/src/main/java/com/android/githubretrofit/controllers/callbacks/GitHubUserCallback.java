package com.android.githubretrofit.controllers.callbacks;

import com.android.githubretrofit.database.model.User;

/**
 * {@author equa1s}
 */
public interface GitHubUserCallback extends GitHubCallback {
    void onSuccess(User user);
    void onFailure(Throwable throwable);
    void onFinish();
}

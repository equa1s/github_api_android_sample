package com.android.githubretrofit.util;

/**
 * {@author equa1s}
 */
public interface Constants {

    interface Url {
        String PATH_SEPARATOR = "/";
    }

    interface GitHubApi {
        String BASE_URL = "https://api.github.com/";
        String USERS_ENDPOINT = "users";
        String REPOSITORIES_ENDPOINT = "repos";
        String FOLLOWERS_ENDPOINT = "followers";
        String FOLLOWONG_ENDPOINT = "following";
        String STARRED_ENDPOINT = "starred";
    }

}

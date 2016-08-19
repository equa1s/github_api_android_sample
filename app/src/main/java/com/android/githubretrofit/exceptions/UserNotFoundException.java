package com.android.githubretrofit.exceptions;

/**
 * {@author equa1s}
 */
public class UserNotFoundException extends NullPointerException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String detailMessage) {
        super(detailMessage);
    }
}

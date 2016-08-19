package com.android.githubretrofit.exceptions;

/**
 * {@author equa1s}
 */
public class EmptyRepositoryException extends Exception {

    public EmptyRepositoryException() {
    }

    public EmptyRepositoryException(String detailMessage) {
        super(detailMessage);
    }

}

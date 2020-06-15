package com.codesquad.issuetracker.ragdoll.exception;

public class UserUnauthorizedException extends BaseException {

    private String errorMessage;

    public UserUnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}

package com.codesquad.issuetracker.ragdoll.exception;

import com.codesquad.issuetracker.ragdoll.response.ApiResponse;

public class BaseException extends RuntimeException {

    private String errorMessage;

    public BaseException(String errorMessage) {
        super(errorMessage);
    }
}

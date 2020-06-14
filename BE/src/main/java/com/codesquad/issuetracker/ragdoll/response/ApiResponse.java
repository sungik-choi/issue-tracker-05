package com.codesquad.issuetracker.ragdoll.response;

import com.codesquad.issuetracker.ragdoll.commonconstant.ResponseMessages;

public class ApiResponse<T> {

    private boolean status;

    private T response;

    public ApiResponse() {}

    private ApiResponse(boolean status, T response) {
        this.status = status;
        this.response = response;
    }

    public static <T> ApiResponse<T> OK(T response) {
        return new ApiResponse(true, response);
    }

    public static <T> ApiResponse<T> CREATED(T response) {return new ApiResponse(true, response); }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

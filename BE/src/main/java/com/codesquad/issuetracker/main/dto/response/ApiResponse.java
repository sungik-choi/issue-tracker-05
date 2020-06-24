package com.codesquad.issuetracker.main.dto.response;

public class ApiResponse<T> {

    private boolean status;

    private T response;

    public ApiResponse() {}

    private ApiResponse(boolean status, T response) {
        this.status = status;
        this.response = response;
    }

    public static <T> ApiResponse<T> OK(T response) {
        return new ApiResponse<>(true, response);
    }

    public static <T> ApiResponse<T> FORBIDDEN(T response) { return new ApiResponse<>(false, response); }

    public static <T> ApiResponse<T> UNAUTHORIZED(T response) { return new ApiResponse<>(false, response); }

    public boolean isStatus() {
        return status;
    }

    public T getResponse() {
        return response;
    }
}

package com.codesquad.issuetracker.ragdoll.exception;

import com.codesquad.issuetracker.ragdoll.commonconstant.ErrorMessages;
import com.codesquad.issuetracker.ragdoll.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserUnauthorizedException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse<String>> handleUserUnauthorizeedException(UserUnauthorizedException userUnauthorizedException) {
        return new ResponseEntity(ApiResponse.UNAUTHORIZED(ErrorMessages.USER_UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }
}

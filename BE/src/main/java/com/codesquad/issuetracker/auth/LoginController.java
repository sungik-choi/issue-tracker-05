package com.codesquad.issuetracker.auth;

import com.codesquad.issuetracker.hamill.dto.response.ApiResponse;
import com.codesquad.issuetracker.hamill.service.UserService_Hamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final UserService_Hamill userService_hamill;

    public LoginController(UserService_Hamill userService_hamill) {
        this.userService_hamill = userService_hamill;
    }

    // replace with Github login
    @PostMapping("/api/users")
    public ResponseEntity<ApiResponse<?>> login(@RequestBody AuthCredential authCredential, HttpSession session) {
        if ("true".equals(authCredential.getCredential())) {
            userService_hamill.save(
                    authCredential.getNewUserDto().getName(),
                    authCredential.getNewUserDto().getEmail(),
                    null,
                    authCredential.getNewUserDto().getAvatarUrl());
            return new ResponseEntity<>(ApiResponse.OK("SUCCESS"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ApiResponse.FORBIDDEN("FAIL"), HttpStatus.FORBIDDEN);
        }
    }

}

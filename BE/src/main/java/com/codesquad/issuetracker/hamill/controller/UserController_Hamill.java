package com.codesquad.issuetracker.hamill.controller;

import com.codesquad.issuetracker.hamill.service.UserService_Hamill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hamill")
public class UserController_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueController_Hamill.class);

    private UserService_Hamill userService_hamill;

    public UserController_Hamill(UserService_Hamill userService_hamill) {
        this.userService_hamill = userService_hamill;
    }

}

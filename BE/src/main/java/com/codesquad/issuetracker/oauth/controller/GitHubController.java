package com.codesquad.issuetracker.oauth.controller;

import com.codesquad.issuetracker.oauth.service.GitHubOauthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
public class GitHubController {
    private static final Logger logger = LoggerFactory.getLogger(GitHubController.class);

    public static final String REDIRECT_URL = "http://13.209.34.90";

    private final GitHubOauthService gitHubOauthService;

    public GitHubController(GitHubOauthService gitHubOauthService) {
        this.gitHubOauthService = gitHubOauthService;
    }

    @GetMapping("/login/oauth")
    public void login(@PathParam("code") String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("##### code: {}", code);
        gitHubOauthService.login( request, response, REDIRECT_URL, code);
    }
}

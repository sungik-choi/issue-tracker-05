package com.codesquad.issuetracker.oauth.service;

import com.codesquad.issuetracker.oauth.domain.GitHubTokenInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface GitHubOauthService {

    GitHubTokenInfo getAccessToken(String code);

    void login(HttpServletRequest request, HttpServletResponse response, String url, String authorizationCode) throws IOException;

    void getUserData(HttpServletRequest request, HttpServletResponse response, String url, String accessToken);

    void sendUserCookies(HttpServletResponse response, String jwt, String url) throws IOException;
}

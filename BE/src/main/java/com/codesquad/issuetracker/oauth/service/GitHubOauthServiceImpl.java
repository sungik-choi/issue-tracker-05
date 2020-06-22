package com.codesquad.issuetracker.oauth.service;

import com.codesquad.issuetracker.config.jwt.hamill.JwtService;
import com.codesquad.issuetracker.hamill.service.UserService_Hamill;
import com.codesquad.issuetracker.oauth.domain.GitHubTokenInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class GitHubOauthServiceImpl implements GitHubOauthService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubOauthServiceImpl.class);

    public static final String GITHUB_ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token";
    public static final String GITHUB_USER_INFO_ACCESS_URL = "https://api.github.com/user";

    private final UserService_Hamill userService_hamill;
    private final JwtService jwtService;

    @Value("${github.client_id}")
    private String clientId;
    @Value("${github.client_secret}")
    private String clientSecret;

    public GitHubOauthServiceImpl(UserService_Hamill userService_hamill, JwtService jwtService) {
        this.userService_hamill = userService_hamill;
        this.jwtService = jwtService;
    }

    public GitHubTokenInfo getAccessToken(String code) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("Accept", "application/json");
        headers.setAll(header);

        MultiValueMap<String, String> bodies = new LinkedMultiValueMap<>();
        Map<String, String> body = new HashMap<>();
        body.put("client_id", clientId);
        body.put("client_secret", clientSecret);
        body.put("code", code);
        bodies.setAll(body);

        HttpEntity<?> request = new HttpEntity<>(bodies, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(GITHUB_ACCESS_TOKEN_URL, request, GitHubTokenInfo.class);
        return (GitHubTokenInfo) response.getBody();
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response, String url, String authorizationCode) throws IOException {
        GitHubTokenInfo gitHubTokenInfo = getAccessToken(authorizationCode);
        logger.info("##### Access Token Type: {}, Access Token: {}",gitHubTokenInfo.getTokenType(), gitHubTokenInfo.getAccessToken());
        this.getUserData(request, response, url, gitHubTokenInfo.getAccessToken());
    }

    public void getUserData(HttpServletRequest request, HttpServletResponse response, String url, String accessToken) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);

            UriComponents sendAccessTokenUrl = UriComponentsBuilder.fromHttpUrl(
                    GITHUB_USER_INFO_ACCESS_URL + "?access_token=" + accessToken).build();

            // 이 한줄의 코드로 API를 호출해 MAP 타입으로 전달 받는다
            ResponseEntity<Map> resultMap = restTemplate.exchange(sendAccessTokenUrl.toString(), HttpMethod.GET, entity, Map.class);

            // 유저 정보가 없을 때만 유저 정보를 저장한다
            if (!userService_hamill.existUserByEmail(Objects.requireNonNull(resultMap.getBody()).get("email").toString())) {
                userService_hamill.save(
                        (Objects.requireNonNull(resultMap.getBody())).get("name").toString(),
                        resultMap.getBody().get("email").toString(),
                        Long.parseLong(resultMap.getBody().get("id").toString()),
                        resultMap.getBody().get("avatar_url").toString());
            }

            // 필요한 정보를 담아 JWT 토큰을 만든다
            String jwt = jwtService.makeJwt(
                    Long.parseLong(resultMap.getBody().get("id").toString()),
                    resultMap.getBody().get("name").toString(),
                    resultMap.getBody().get("avatar_url").toString());
            this.sendUserCookies(response, jwt, url);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.info("##### HttpErrorException: {}", e.getMessage());
        } catch (Exception e) {
            logger.info("##### Exception: {}", e.getMessage());
        }
    }

    public void sendUserCookies(HttpServletResponse response, String jwt, String url) throws IOException {
        Cookie cookie = new Cookie("token", jwt);
        response.addCookie(cookie);
        response.sendRedirect(url);
    }
}

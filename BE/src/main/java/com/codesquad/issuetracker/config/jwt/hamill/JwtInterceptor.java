package com.codesquad.issuetracker.config.jwt.hamill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
    private static final String HEADER_AUTH = "Authorization";

    private final JwtService jwtService;

    public JwtInterceptor(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader(HEADER_AUTH);

        if (token != null && jwtService.checkJwt(token)){
            return true;
        } else {
            response.sendError(401);
            logger.info("##### 로그인을 먼저 해주세요");
            return false;
        }
    }
}

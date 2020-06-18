package com.codesquad.issuetracker.hamill.service;

import com.codesquad.issuetracker.hamill.dao.UserDao_Hamill;
import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(UserService_Hamill.class);

    private UserDao_Hamill userDao_hamill;

    public UserService_Hamill(UserDao_Hamill userDao_hamill) {
        this.userDao_hamill = userDao_hamill;
    }

    public List<UserSummary> findUserInformation() {
        List<User> users = userDao_hamill.findAllUsers();
        List<UserSummary> userSummaries = new ArrayList<>();

        for (User value : users) {
            UserSummary userSummary = UserSummary.of(value.getId(), value.getName(), value.getAvatarUrl());
            userSummaries.add(userSummary);
        }

        return userSummaries;
    }

    public List<UserSummary> findUserSummaryByIssueId(Long issueId) {
        return userDao_hamill.findUserSummaryByIssueId(issueId);
    }

    public User findUserByUserId(Long userId) {
        return userDao_hamill.findUserByUserId(userId);
    }
}

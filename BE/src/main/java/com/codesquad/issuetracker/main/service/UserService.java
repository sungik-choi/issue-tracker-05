package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.UserDao;
import com.codesquad.issuetracker.main.domain.User;
import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserSummary> findUserSummaries() {
        List<User> users = userDao.findAllUsers();
        List<UserSummary> userSummaries = new ArrayList<>();

        for (User value : users) {
            UserSummary userSummary = UserSummary.of(value.getId(), value.getName(), value.getAvatarUrl());
            userSummaries.add(userSummary);
        }

        return userSummaries;
    }

    public List<UserSummary> findUserSummariesByIssueId(Long issueId) {
        return userDao.findUserSummariesByIssueId(issueId);
    }

    public User findUserByUserId(Long userId) {
        return userDao.findUserByUserId(userId);
    }

    public Boolean existUserByEmail(String email) {
        return userDao.existUserByEmail(email);
    }

    public UserSummary findUserSummaryByIssueIdAndCommentId(Long issueId, Long commentId) {
        return userDao.findUserSummaryByIssueIdAndCommentId(issueId, commentId);
    }

    public void save(String name, String email, Long githubId, String avatarUrl) {
        userDao.save(name, email, githubId, avatarUrl);
    }
}

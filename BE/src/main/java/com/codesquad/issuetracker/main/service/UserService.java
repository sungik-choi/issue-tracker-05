package com.codesquad.issuetracker.main.service;

import com.codesquad.issuetracker.main.dao.UserDao;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserSummary> findAllocatedAssigneesByIds(Long issueId) {
        return userDao.findAllocatedAssigneesByIds(issueId);
    }

    public User findUserById(Long userId) {
        return userDao.findUserById(userId);
    }

    public List<UserSummary> findAllAssignees() {
        List<User> allUsers = userDao.findAllUsers();
        return allUsers.stream()
                       .map(user -> UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl()))
                       .collect(Collectors.toList());
    }
}

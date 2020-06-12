package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.UserDaoRagdoll;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.dto.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceRagdoll {

    private final UserDaoRagdoll userDaoRagdoll;

    public UserServiceRagdoll(UserDaoRagdoll userDaoRagdoll) {
        this.userDaoRagdoll = userDaoRagdoll;
    }

    public List<UserSummary> findAllocatedAssigneesByIds(Long issueId) {
        return userDaoRagdoll.findAllocatedAssigneesByIds(issueId);
    }

    public User findUserById(Long userId) {
        return userDaoRagdoll.findUserById(userId);
    }

    public List<UserSummary> findAllAssignees() {
        List<User> allUsers = userDaoRagdoll.findAllUsers();
        return allUsers.stream()
                       .map(user -> UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl()))
                       .collect(Collectors.toList());
    }
}

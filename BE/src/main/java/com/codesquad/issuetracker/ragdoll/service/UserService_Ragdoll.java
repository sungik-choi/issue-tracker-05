<<<<<<< HEAD
package com.codesquad.issuetracker.ragdoll.service;

import com.codesquad.issuetracker.ragdoll.dao.UserDao_Ragdoll;
import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService_Ragdoll {

    private final UserDao_Ragdoll userDao;

    public UserService_Ragdoll(UserDao_Ragdoll userDao) {
        this.userDao = userDao;
    }

    public List<UserSummary> findAllocatedAssigneesByIssueId(Long issueId) {
        return userDao.findAllocatedAssigneesByIssueId(issueId);
    }

    public User findUserById(Long userId) {
        return userDao.findUserById(userId);
    }

    public List<UserSummary> findAllAssignees() {
        List<User> allUsers = userDao.findAllUsers();
        return allUsers.stream()
                       .map(user -> UserSummary.of(user.getId(), user.getName(), user.getAvatarUrl()))
                       .collect(Collectors.toList());
    }
}
=======
//package com.codesquad.issuetracker.ragdoll.service;
//
//import com.codesquad.issuetracker.ragdoll.dao.UserDao_Ragdoll;
//import com.codesquad.issuetracker.ragdoll.domain.User;
//import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService_Ragdoll {
//
//    private final UserDao_Ragdoll userDao;
//
//    public UserService_Ragdoll(UserDao_Ragdoll userDao) {
//        this.userDao = userDao;
//    }
//
//    public List<UserSummary> findAllocatedAssigneesByIssueId(Long issueId) {
//        return userDao.findAllocatedAssigneesByIssueId(issueId);
//    }
//
//    public User findUserById(Long userId) {
//        return userDao.findUserById(userId);
//    }
//
//    public List<UserSummary> findAllAssignees() {
//        List<User> allUsers = userDao.findAllUsers();
//        return allUsers.stream()
//                       .map(user -> UserSummary.create(user.getId(), user.getName(), user.getAvatarUrl()))
//                       .collect(Collectors.toList());
//    }
//}
>>>>>>> be/dev

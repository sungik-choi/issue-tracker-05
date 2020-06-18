package com.codesquad.issuetracker.hamill.dao;

import com.codesquad.issuetracker.hamill.domain.User;
import com.codesquad.issuetracker.hamill.vo.UserVO.UserSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(UserDao_Hamill.class);

    private JdbcTemplate jdbcTemplate;

    public UserDao_Hamill(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAllUsers() {

        return jdbcTemplate.query(
                "SELECT u.id, u.name, u.email, u.github_id, u.avatar_url, u.created_date_time FROM user u",
                (rs, rowNum) ->
                        User.of(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getLong("github_id"),
                                rs.getString("avatar_url"),
                                rs.getTimestamp("created_date_time").toLocalDateTime())
        );
    }

    public List<UserSummary> findUserSummaryByIssueId(Long issueId) {
        return jdbcTemplate.query(
                "SELECT user.id, user.name, user.avatar_url FROM user " +
                        "JOIN assignee a ON user.id = a.user_id " +
                        "WHERE a.issue_id = ?",
                (rs, rowNum) ->
                        UserSummary.of(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("avatar_url"))
        , issueId);
    }

    public User findUserByUserId(Long userId) {
        return jdbcTemplate.queryForObject(
                "SELECT u.id, u.name, u.email, u.github_id, u.avatar_url, u.created_date_time FROM user u WHERE u.id = ?",
                (rs, rowNum) ->
                        User.of(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getLong("github_id"),
                                rs.getString("avatar_url"),
                                rs.getTimestamp("created_date_time").toLocalDateTime())
        ,userId);
    }
}

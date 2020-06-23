package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.main.domain.User;
import com.codesquad.issuetracker.main.vo.UserVO.UserSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
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

    public List<UserSummary> findUserSummariesByIssueId(Long issueId) {
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

    public Boolean existUserByEmail(String email) {
        String sql = "select exists(select * from user where email = ?) as success;";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> rs.getBoolean("success"), email);
    }

    public UserSummary findUserSummaryByIssueIdAndCommentId(Long issueId, Long commentId) {
        return jdbcTemplate.queryForObject(
                "SELECT user.id, user.name, user.avatar_url FROM user " +
                        "JOIN comment c ON user.id = c.user_id " +
                        "WHERE c.issue_id = ? AND c.id",
                (rs, rowNum) ->
                        UserSummary.of(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("avatar_url"))
                , issueId, commentId);
    }

    public void save(String name, String email, Long githubId, String avatarUrl) {
        String sql =
                "INSERT INTO user(name, email, github_id, created_date_time, avatar_url) " +
                "VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,name, email, githubId, Timestamp.valueOf(LocalDateTime.now()), avatarUrl);
    }
}

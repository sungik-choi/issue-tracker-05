package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.User;
import com.codesquad.issuetracker.ragdoll.vo.userVO.UserSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    public UserDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<UserSummary> findAllocatedAssigneesByIssueId(Long issueId) {
        String sql = "SELECT u.id, u.name, u.avatar_url " +
                     "FROM user u JOIN assignee a ON u.id = a.user_id " +
                     "WHERE a.issue_id = ?";
        return jdbcTemplate.query(sql, new Object[] {issueId},
                (rs, rowNum) -> UserSummary.of(rs.getLong("u.id"), rs.getString("u.name"),
                                                   rs.getString("u.avatar_url")));
    }

    public User findUserById(Long userId) {
        String sql = "SELECT id, name, email, github_id, avatar_url, created_date_time " +
                     "FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId},
                (rs, rowNum) -> new User.Builder()
                                        .id(rs.getLong("id"))
                                        .name(rs.getString("name"))
                                        .email(rs.getString("email"))
                                        .githubId(rs.getLong("github_id"))
                                        .avatarUrl(rs.getString("avatar_url"))
                                        .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                        .build());
    }

    public List<User> findAllUsers() {
        String sql = "SELECT id, name, email, github_id, avatar_url, created_date_time " +
                     "FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User.Builder()
                                                               .id(rs.getLong("id"))
                                                               .name(rs.getString("name"))
                                                               .email(rs.getString("email"))
                                                               .githubId(rs.getLong("github_id"))
                                                               .avatarUrl(rs.getString("avatar_url"))
                                                               .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                                               .build());
    }
}

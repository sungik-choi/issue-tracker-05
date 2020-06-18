package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Comment;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public IssueDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Issue findIssueById(Long issueId) {
        String sql = "SELECT id, title, created_date_time, is_opened, user_id, milestone_id " +
                     "FROM issue WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{issueId},
                (rs, rowNum) -> new Issue.Builder()
                                         .id(rs.getLong("id"))
                                         .title(rs.getString("title"))
                                         .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                         .opened(rs.getBoolean("is_opened"))
                                         .userId(rs.getLong("user_id"))
                                         .milestoneId(rs.getInt("milestone_id"))
                                         .build());
    }

    public List<Issue> findAllOpendIssues() {
        String sql = "SELECT id, title, created_date_time, is_opened, user_id, milestone_id " +
                     "FROM issue WHERE is_opened = TRUE";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Issue.Builder()
                                                                .id(rs.getLong("id"))
                                                                .title(rs.getString("title"))
                                                                .createdDateTime((rs.getTimestamp("created_date_time")).toLocalDateTime())
                                                                .opened(rs.getBoolean("is_opened"))
                                                                .userId(rs.getLong("user_id"))
                                                                .milestoneId(rs.getInt("milestone_id"))
                                                                .build());
    }

    public Long submitNewIssue(Long authorId, String title) {
        String sql = "INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) " +
                     "VALUES (:title, :createdDateTime, :isOpened, :authorId, :milestoneId)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("title", title)
                                                .addValue("createdDateTime", LocalDateTime.now())
                                                .addValue("isOpened", true)
                                                .addValue("authorId", authorId)
                                                .addValue("milestoneId", null);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Number registeredNewIssueId = namedParameterJdbcTemplate.update(sql, namedParameters, keyHolder, new String[]{"registeredNewIssueId"});
        return keyHolder.getKey().longValue();
    }

    public void submitNewComment(Long commenterId, Long issueId, String description) {
        String sql = "INSERT INTO comment (description, created_date_time, issue_id, user_id) " +
                     "VALUES (:description, :createdDateTime, :issueId, :commenterId)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("description", description)
                                                .addValue("createdDateTime", LocalDateTime.now())
                                                .addValue("issueId", issueId)
                                                .addValue("commenterId", commenterId);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public List<Comment> findAllCommentsByIssueId(Long issueId) {
        String sql = "SELECT id, description, created_date_time, issue_id, user_id " +
                     "FROM comment WHERE issue_id = ?";
        return jdbcTemplate.query(sql, new Object[]{issueId},
                (rs, rowNum) -> new Comment.Builder()
                                           .id(rs.getLong("id"))
                                           .description(rs.getString("description"))
                                           .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                           .issueId(rs.getLong("issue_id"))
                                           .userId(rs.getLong("user_id"))
                                           .build());
    }

    public List<Issue> findIssuesByMilestoneId(Integer milestoneId) {
        String sql = "SELECT id, title, created_date_time, is_opened, user_id, milestone_id " +
                     "FROM issue WHERE milestone_id = ?";
        return jdbcTemplate.query(sql, new Object[]{milestoneId},
                (rs, rowNum) -> new Issue.Builder()
                                         .id(rs.getLong("id"))
                                         .title(rs.getString("title"))
                                         .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                         .opened(rs.getBoolean("is_opened"))
                                         .userId(rs.getLong("user_id"))
                                         .milestoneId(rs.getInt("milestone_id"))
                                         .build());
    }

    public void modifyIssueTitle(Long issueId, String issueTitle) {
        String sql = "UPDATE issue SET title = ? " +
                     "WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{issueTitle, issueId});
    }

    public void modifyIssueStats(Long issueId, boolean opened) {
        String sql = "UPDATE issue SET is_opened = ? " +
                     "WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{opened, issueId});
    }

    public void addAssigneeId(Long issueId, Long addedAssigneeId) {
        String sql = "INSERT assignee (issue_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{issueId, addedAssigneeId});
    }

    public void deleteAssigneeId(Long issueId, Long deletedAssigneeId) {
        String sql = "DELETE FROM assignee WHERE issue_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, new Object[]{issueId, deletedAssigneeId});
    }

    public void addAttachedLabelId(Long issueId, Integer labelId) {
        String sql = "INSERT issue_has_label (label_id, issue_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, new Object[]{labelId, issueId});
    }

    public void deleteAttachedLabelId(Long issueId, Integer labelId) {
        String sql = "DELETE FROM issue_has_label WHERE issue_id = ? AND label_id = ?";
        jdbcTemplate.update(sql, new Object[]{issueId, labelId});
    }

    public void updateRelatedMilestone(Long issueId, Integer milestoneId) {
        String sql = "UPDATE issue SET milestone_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{milestoneId, issueId});
    }

    public void updateComment(Long issueId, Long commentId, String description) {
        String sql = "UPDATE comment SET description = ? WHERE issue_id = ? AND id = ?";
        jdbcTemplate.update(sql, new Object[]{description, issueId, commentId});
    }
}

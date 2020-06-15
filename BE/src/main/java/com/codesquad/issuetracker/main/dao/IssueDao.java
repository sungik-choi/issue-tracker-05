package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.hamill.dto.AuthorDto;
import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
import com.codesquad.issuetracker.hamill.dto.milestone.MilestoneDto;
import com.codesquad.issuetracker.main.vo.issueVO.IssueDetails;
import com.codesquad.issuetracker.ragdoll.domain.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueDao {

    private final JdbcTemplate jdbcTemplate;

    public IssueDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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

    public IssuesDto findIssueByIssueId(Long issueId) {
        return jdbcTemplate.queryForObject(
                    "SELECT i.id AS issue_id, i.title, i.is_opened, m.id AS milestone_id, m.title AS milestone_title," +
                        " i.created_date_time,u.id AS user_id, u.name AS user_name, u.avatar_url\n" +
                        "FROM issue i\n" +
                        "         JOIN milestone m ON i.milestone_id = m.id\n" +
                        "         JOIN user u ON i.user_id = u.id " +
                        "WHERE i.id = ?",
                (rs, rowNum) ->
                        IssuesDto.builder()
                                 .issueId(rs.getLong("issue_id"))
                                 .issueTitle(rs.getString("title"))
                                 .isOpened(rs.getBoolean("is_opened"))
                                 .milestone(getMilestoneDto(rs))
                                 .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                 .author(getAuthorDto(rs))
                                 .build()
                , issueId);
    }

    private MilestoneDto getMilestoneDto(ResultSet rs) throws SQLException {
        return MilestoneDto.builder()
                           .milestoneId(rs.getLong("milestone_id"))
                           .milestoneTitle(rs.getString("milestone_title"))
                           .build();
    }

    private AuthorDto getAuthorDto(ResultSet rs) throws SQLException {
        return AuthorDto.builder()
                        .userId(rs.getLong("user_id"))
                        .userName(rs.getString("user_name"))
                        .avatarUrl(rs.getString("avatar_url"))
                        .build();
    }

    public Integer getCountOfIssues() {
        return jdbcTemplate.queryForObject("SELECT count(issue.id) FROM issue", Integer.TYPE);
    }

    public void saveNewIssue(Long issueId, String title, Long userId, Long milestoneId) {
        String sql =
                "INSERT INTO issue(id, title, created_date_time, is_opened, user_id, milestone_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, issueId, title, Timestamp.valueOf(LocalDateTime.now()), true, userId, milestoneId);
    }

    public void saveNewIssueHasLabel(Long labelId, Long issueId) {
        String sql = "INSERT INTO issue_has_label(label_id, issue_id) VALUES (?, ?) ";
        jdbcTemplate.update(sql, labelId, issueId);
    }

    public void saveAssignees(Long issueId, Long userId) {
        String sql = "INSERT INTO assignee(issue_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, issueId, userId);
    }
}

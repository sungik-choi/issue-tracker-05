package com.codesquad.issuetracker.hamill.dao;

import com.codesquad.issuetracker.hamill.controller.IssueController_Hamill;
import com.codesquad.issuetracker.hamill.dto.AssigneeDto;
import com.codesquad.issuetracker.hamill.dto.AuthorDto;
import com.codesquad.issuetracker.hamill.dto.info.IssuesDto;
import com.codesquad.issuetracker.hamill.dto.label.LabelDto;
import com.codesquad.issuetracker.hamill.dto.milestone.MilestoneDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueDao_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(IssueController_Hamill.class);

    private JdbcTemplate jdbcTemplate;

    public IssueDao_Hamill(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public IssuesDto findIssueByIssueId(Long issueId) {
        return jdbcTemplate.queryForObject(
                    "SELECT i.id AS issue_id, i.title, i.is_opened, m.id AS milestone_id, m.title AS milestone_title, i.created_date_time,u.id AS user_id, u.name AS user_name, u.avatar_url\n" +
                        "FROM issue i\n" +
                        "         JOIN milestone m on i.milestone_id = m.id\n" +
                        "         JOIN user u on i.user_id = u.id " +
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

    public List<LabelDto> findLabelsByIssuesId(Long issueId) {
        return jdbcTemplate.query(
                    "SELECT l.id AS label_id, l.name AS label_name, l.hex_code AS hex_code\n" +
                        "FROM label l\n" +
                        "                         JOIN issue_has_label ihl on l.id = ihl.label_id\n" +
                        "WHERE ihl.issue_id = ?;",
                (rs, rowNum) ->
                        LabelDto.builder()
                                .labelId(rs.getLong("label_id"))
                                .labelName(rs.getString("label_name"))
                                .hexCode(rs.getString("hex_code"))
                                .build()
        , issueId);
    }

    public List<AssigneeDto> findAssigneeByIssueId(Long issueId) {
        return jdbcTemplate.query(
                    "SELECT u.id AS user_id, u.name AS user_name, u.avatar_url " +
                        "FROM assignee a\n" +
                        "                         JOIN user u on a.user_id = u.id\n " +
                        "                         JOIN issue i on a.issue_id = i.id " +
                        "WHERE i.id = ?",
                (rs, rowNum) ->
                        AssigneeDto.builder()
                                   .userId(rs.getLong("user_id"))
                                   .userName(rs.getString("user_name"))
                                   .avatarUrl(rs.getString("avatar_url"))
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
        return jdbcTemplate.queryForObject( "SELECT count(issue.id) FROM issue", Integer.TYPE);
    }

    public void saveNewIssue(Long issueId, String title, Long userId, Long milestoneId) {
        String sql =
                "INSERT INTO issue(id, title, created_date_time, is_opened, user_id, milestone_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, issueId,title, Timestamp.valueOf(LocalDateTime.now()), true, userId, milestoneId);
    }

    public void saveNewIssueHasLabel(Long labelId, Long issueId) {
        logger.info("##### labelId: {}", labelId);
        logger.info("##### issueId: {}", issueId);
        String sql = "INSERT INTO issue_has_label(label_id, issue_id) VALUES (?, ?) ";
        jdbcTemplate.update(sql, labelId, issueId);
    }

    public void saveAssignees(Long issueId, Long userId) {
        String sql = "INSERT INTO assignee(issue_id, user_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, issueId, userId);
    }


}

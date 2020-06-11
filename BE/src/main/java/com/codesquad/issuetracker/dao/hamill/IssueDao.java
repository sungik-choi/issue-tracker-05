package com.codesquad.issuetracker.dao.hamill;

import com.codesquad.issuetracker.controller.hamill.IssueController;
import com.codesquad.issuetracker.dto.hamill.AssigneeDto;
import com.codesquad.issuetracker.dto.hamill.info.IssuesDto;
import com.codesquad.issuetracker.dto.hamill.label.LabelDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssueDao {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    private JdbcTemplate jdbcTemplate;

    public IssueDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IssuesDto> findAllIssues() {
        String sql =
                "SELECT i.id AS issue_id, i.title, i.is_opened, m.title AS milestone_title, i.created_date_time, u.name AS author\n" +
                        "FROM issue i\n" +
                        "         JOIN milestone m on i.milestone_id = m.id\n" +
                        "         JOIN user u on i.user_id = u.id;";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        IssuesDto.builder()
                                 .issueId(rs.getLong("issue_id"))
                                 .title(rs.getString("title"))
                                 .isOpened(rs.getBoolean("is_opened"))
                                 .milestoneTitle(rs.getString("milestone_title"))
                                 .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                 .author(rs.getString("author"))
                                 .build()
        );
    }

    public IssuesDto findIssueByIssueId(Long issueId) {
        String sql =
                "SELECT i.id AS issue_id, i.title, i.is_opened, m.title AS milestone_title, i.created_date_time, u.name AS author\n" +
                        "FROM issue i\n" +
                        "         JOIN milestone m on i.milestone_id = m.id\n" +
                        "         JOIN user u on i.user_id = u.id WHERE i.id = ?;";
        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) ->
                        IssuesDto.builder()
                                 .issueId(rs.getLong("issue_id"))
                                 .title(rs.getString("title"))
                                 .isOpened(rs.getBoolean("is_opened"))
                                 .milestoneTitle(rs.getString("milestone_title"))
                                 .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                 .author(rs.getString("author"))
                                 .build()
        , issueId);
    }

    public List<LabelDto> findLabelsByIssuesId(Long issueId) {

        String sql =
                "SELECT l.id AS label_id, l.name AS label_name, l.hex_code AS hex_code\n" +
                        "FROM label l\n" +
                        "         JOIN issue_has_label ihl on l.id = ihl.label_id\n" +
                        "WHERE ihl.issue_id = ?;";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        LabelDto.builder()
                                .id(rs.getLong("label_id"))
                                .labelName(rs.getString("label_name"))
                                .hexCode(rs.getString("hex_code"))
                                .build()
        , issueId);
    }

    public List<AssigneeDto> findAssigneeByIssueId(Long issueId) {
        String sql =
                "SELECT u.id AS user_id, u.name AS user_name\n" +
                        "                FROM assignee a\n" +
                        "                         JOIN user u on a.user_id = u.id\n" +
                        "JOIN issue i on a.issue_id = i.id WHERE i.id = ?";
        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        AssigneeDto.builder()
                                   .userId(rs.getLong("user_id"))
                                   .userName(rs.getString("user_name"))
                                   .build()
        , issueId);
    }
}

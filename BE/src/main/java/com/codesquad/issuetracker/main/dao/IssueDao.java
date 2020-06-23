package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.main.domain.Issue;
import com.codesquad.issuetracker.main.dto.request.NewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueDao {

    private static final Logger logger = LoggerFactory.getLogger(IssueDao.class);

    private JdbcTemplate jdbcTemplate;

    public IssueDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Issue> findAllIssues() {
        return jdbcTemplate.query(
                "SELECT i.id, i.title, i.created_date_time, i.is_opened, i.user_id, i.milestone_id FROM issue i",
                (rs, rowNum) ->
                        Issue.of(rs.getLong("id"),
                                rs.getString("title"),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getBoolean("is_opened"),
                                rs.getLong("user_id"),
                                rs.getInt("milestone_id"))
        );
    }

    public void save(NewIssueDto newIssueDto) {
        String sql =
                "INSERT INTO issue(title, created_date_time, is_opened, user_id) " +
                "VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                newIssueDto.getTitle(),
                Timestamp.valueOf(LocalDateTime.now()),
                true, newIssueDto.getUserId());
    }

    public Issue findIssueByIssueId(Long issueId) {
        return jdbcTemplate.queryForObject(
                "SELECT i.id, i.title, i.created_date_time, i.is_opened, i.user_id, i.milestone_id FROM issue i WHERE i.id = ?",
                (rs, rowNum) ->
                        Issue.of(rs.getLong("id"),
                                rs.getString("title"),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getBoolean("is_opened"),
                                rs.getLong("user_id"),
                                rs.getInt("milestone_id"))
        , issueId);
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

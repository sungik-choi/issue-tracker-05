package com.codesquad.issuetracker.main.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IssueHasLabelDao {

    private static final Logger logger = LoggerFactory.getLogger(IssueHasLabelDao.class);

    private JdbcTemplate jdbcTemplate;

    public IssueHasLabelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void deleteIssueHasLabelByLabelId(Integer labelId) {
        String sql = "DELETE FROM issue_has_label WHERE label_id = ?";
        jdbcTemplate.update(sql, labelId);
    }

    public void addedAttachedLabel(Long issueId, Integer labelId) {
        String sql = "INSERT INTO issue_has_label(label_id, issue_id) VALUES (?, ?) ";
        jdbcTemplate.update(sql,labelId, issueId);
    }

    public void deletedAttachedLabel(Long issueId, Integer labelId) {
        String sql = "DELETE FROM issue_has_label WHERE issue_id = ? AND label_id = ?";
        jdbcTemplate.update(sql, issueId, labelId);
    }
}

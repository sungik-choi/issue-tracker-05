package com.codesquad.issuetracker.hamill.dao;

import com.codesquad.issuetracker.hamill.domain.Label;
import com.codesquad.issuetracker.hamill.vo.labelVO.LabelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabelDao_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(LabelDao_Hamill.class);

    private JdbcTemplate jdbcTemplate;

    public LabelDao_Hamill(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Label> findAllLabels() {
        return jdbcTemplate.query(
                "SELECT * FROM label",
                (rs, rowNum) ->
                        Label.of(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("background_color"),
                                rs.getString("color"))
        );
    }

    public List<LabelSummary> findLabelSummaryByIssueId(Long issueId) {
        return jdbcTemplate.query(
                "SELECT label.id, label.name, label.background_color, label.color FROM label " +
                        "JOIN issue_has_label ON label.id = issue_has_label.label_id " +
                        "WHERE issue_has_label.issue_id = ?",
                (rs, rowNum) ->
                        LabelSummary.of(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("background_color"),
                                rs.getString("color"))
        , issueId);
    }
}

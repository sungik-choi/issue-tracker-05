package com.codesquad.issuetracker.hamill.dao;

import com.codesquad.issuetracker.hamill.domain.Label;
import com.codesquad.issuetracker.hamill.domain.Milestone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MilestoneDao_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(MilestoneDao_Hamill.class);

    private JdbcTemplate jdbcTemplate;

    public MilestoneDao_Hamill(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Milestone> findAllMilestones() {
        return jdbcTemplate.query(
                "SELECT * FROM issue_tracker.milestone",
                (rs, rowNum) ->
                        Milestone.of(rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getDate("due_date").toLocalDate(),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getTimestamp("updated_date_time").toLocalDateTime())
        );
    }

    public Milestone findMilestoneByMilestoneId(Integer milestoneId) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM milestone WHERE milestone.id = ?",
                (rs, rowNum) ->
                        Milestone.of(rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getDate("due_date").toLocalDate(),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getTimestamp("updated_date_time").toLocalDateTime())
        , milestoneId);
    }
}

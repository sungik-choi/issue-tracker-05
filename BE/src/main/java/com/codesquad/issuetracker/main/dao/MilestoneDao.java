package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.main.domain.Milestone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MilestoneDao {

    private static final Logger logger = LoggerFactory.getLogger(MilestoneDao.class);

    private JdbcTemplate jdbcTemplate;

    public MilestoneDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Milestone> findAllMilestones() {
        return jdbcTemplate.query(
                "SELECT m.id, m.title, m.description, m.due_date, m.created_date_time, m.updated_date_time, m.progress " +
                        "FROM milestone m",
                (rs, rowNum) ->
                        Milestone.of(rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getDate("due_date").toLocalDate(),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getTimestamp("updated_date_time").toLocalDateTime(),
                                rs.getDouble("progress"))
        );
    }

    public Milestone findMilestoneByMilestoneId(Integer milestoneId) {
        return jdbcTemplate.queryForObject(
                "SELECT m.id, m.title, m.description, m.due_date, m.created_date_time, m.updated_date_time, m.progress " +
                        "FROM milestone m WHERE m.id = ?",
                (rs, rowNum) ->
                        Milestone.of(rs.getInt("id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getDate("due_date").toLocalDate(),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getTimestamp("updated_date_time").toLocalDateTime(),
                                rs.getDouble("progress"))
        , milestoneId);
    }
}

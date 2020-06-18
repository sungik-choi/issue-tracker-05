package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class MilestoneDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MilestoneDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public Milestone findMilestoneById(Integer milestoneId) {
        String sql = "SELECT id, title, description, due_date, created_date_time, updated_date_time " +
                     "FROM milestone WHERE id = ?";
        return DataAccessUtils.singleResult(jdbcTemplate.query(sql, new Object[]{milestoneId},
                (rs, rowNum) -> new Milestone.Builder()
                                             .id(rs.getInt("id"))
                                             .title(rs.getString("title"))
                                             .description(rs.getString("description"))
                                             .dueDate(rs.getDate("due_date").toLocalDate())
                                             .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                             .updatedDateTime(rs.getTimestamp("updated_date_time").toLocalDateTime())
                                             .build()));
    }

    public List<Milestone> findAllMilestones() {
        String sql = "SELECT id, title, description, due_date, created_date_time, updated_date_time " +
                     "FROM milestone";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Milestone.Builder()
                                                                    .id(rs.getInt("id"))
                                                                    .title(rs.getString("title"))
                                                                    .description(rs.getString("description"))
                                                                    .dueDate(rs.getDate("due_date").toLocalDate())
                                                                    .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                                                    .updatedDateTime(rs.getTimestamp("updated_date_time").toLocalDateTime())
                                                                    .build());
    }

    public Integer findCountOfOpenedIssueById(Integer milestoneId, boolean isOpened) {
        String sql = "SELECT COUNT(*) FROM issue i JOIN milestone m ON i.milestone_id = m.id " +
                     "WHERE i.milestone_id = ? AND i.is_opened = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{milestoneId, isOpened}, Integer.class);
    }

    public void createNewMilestone(String title, LocalDate dueDate, String description) {
        String sql = "INSERT INTO milestone (title, description, due_date, created_date_time, updated_date_time) " +
                     "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{title, description, dueDate, LocalDateTime.now(), LocalDateTime.now()});
    }

    public void updateMilestone(Integer milestoneId, String title, LocalDate dueDate, String description) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("milestoneId", milestoneId)
                                                .addValue("title", title)
                                                .addValue("dueDate", dueDate)
                                                .addValue("description", description)
                                                .addValue("updatedDateTime", LocalDateTime.now());
        String sql = "UPDATE milestone SET title = :title, due_date = :dueDate, description = :description, updated_date_time = :updatedDateTime " +
                     "WHERE id = :milestoneId";
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void deleteMilestone(Integer milestoneId) {
        String sql = "DELETE FROM milestone WHERE id = ?";
        jdbcTemplate.update(sql, milestoneId);
    }
}

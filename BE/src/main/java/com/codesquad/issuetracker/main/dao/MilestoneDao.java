package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.ragdoll.domain.Milestone;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MilestoneDao {

    private final JdbcTemplate jdbcTemplate;

    public MilestoneDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Milestone findMilestoneById(Integer milestoneId) {
        String sql = "SELECT id, title, description, due_date, created_date_time, updated_date_time " +
                     "FROM milestone WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{milestoneId},
                (rs, rowNum) -> new Milestone.Builder()
                                             .id(rs.getInt("id"))
                                             .title(rs.getString("title"))
                                             .description(rs.getString("description"))
                                             .dueDate(rs.getDate("due_date").toLocalDate())
                                             .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                             .updatedDateTime(rs.getTimestamp("updated_date_time").toLocalDateTime())
                                             .build());
    }

    public List<Milestone> findAllMilestones() {
        String sql = "SELECT id, title, description, due_date, created_date_time, updated_date_time " +
                     "FROM milestone";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Milestone.Builder()
                                                                    .id(rs.getInt("id"))
                                                                    .title(rs.getString("title"))
                                                                    .dueDate(rs.getDate("due_date").toLocalDate())
                                                                    .createdDateTime(rs.getTimestamp("created_date_time").toLocalDateTime())
                                                                    .updatedDateTime(rs.getTimestamp("updated_date_time").toLocalDateTime())
                                                                    .build());
    }
}

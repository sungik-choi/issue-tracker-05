package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.ragdoll.domain.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
}

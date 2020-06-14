package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Issue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class IssueDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public IssueDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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

    public Long submitNewIssue(Long authorId, String title) {
        String sql = "INSERT INTO issue (title, created_date_time, is_opened, user_id, milestone_id) " +
                     "VALUES (:title, :createdDateTime, :isOpened, :authorId, :milestoneId)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("title", title)
                                                .addValue("createdDateTime", LocalDateTime.now())
                                                .addValue("isOpened", true)
                                                .addValue("authorId", authorId)
                                                .addValue("milestoneId", null);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        Number registeredNewIssueId = namedParameterJdbcTemplate.update(sql, namedParameters, keyHolder, new String[]{"registeredNewIssueId"});
        return keyHolder.getKey().longValue();
    }

    public void registerNewComment(Long commenterId, Long issueId, String description) {
        String sql = "INSERT INTO comment (description, created_date_time, issue_id, user_id) " +
                     "VALUES (:description, :createdDateTime, :issueId, :commenterId)";
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("description", description)
                                                .addValue("createdDateTime", LocalDateTime.now())
                                                .addValue("issueId", issueId)
                                                .addValue("commenterId", commenterId);
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }
}

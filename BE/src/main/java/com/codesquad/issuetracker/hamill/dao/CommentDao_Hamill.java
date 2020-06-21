package com.codesquad.issuetracker.hamill.dao;

import com.codesquad.issuetracker.hamill.dto.request.NewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class CommentDao_Hamill {

    private static final Logger logger = LoggerFactory.getLogger(CommentDao_Hamill.class);

    private JdbcTemplate jdbcTemplate;

    public CommentDao_Hamill(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(NewIssueDto newIssueDto) {
        String sql =
                "INSERT INTO comment(description, created_date_time, issue_id, user_id) " +
                "VALUES(?, ?, LAST_INSERT_ID(), ?)";

        jdbcTemplate.update(sql,
                newIssueDto.getDescription(),
                Timestamp.valueOf(LocalDateTime.now()),
                newIssueDto.getUserId());
    }
}

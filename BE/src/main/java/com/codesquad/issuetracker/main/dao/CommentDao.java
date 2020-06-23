package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.main.domain.Comment;
import com.codesquad.issuetracker.main.dto.request.NewCommentDto;
import com.codesquad.issuetracker.main.dto.request.NewIssueDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentDao {

    private static final Logger logger = LoggerFactory.getLogger(CommentDao.class);

    private JdbcTemplate jdbcTemplate;

    public CommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> findAllComments() {
        String sql = "SELECT c.id, c.description, c.created_date_time, c.issue_id, c.user_id FROM comment c";
        return jdbcTemplate.query(
                sql,
                (rs,rowNum) ->
                        Comment.of(
                                rs.getLong("id"),
                                rs.getString("description"),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getLong("issue_id"),
                                rs.getLong("user_id"))
        );
    }

    public List<Comment> findAllCommentsByIssueId(Long issueId) {
        String sql = "SELECT c.id, c.description, c.created_date_time, c.issue_id, c.user_id FROM comment c WHERE c.issue_id = ?";
        return jdbcTemplate.query(
                sql,
                (rs,rowNum) ->
                        Comment.of(
                                rs.getLong("id"),
                                rs.getString("description"),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getLong("issue_id"),
                                rs.getLong("user_id"))
        , issueId);
    }

    public Comment findCommentByIssueId(Long issueId) {
        String sql = "SELECT c.id, c.description, c.created_date_time, c.issue_id, c.user_id FROM comment c WHERE c.issue_id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                (rs,rowNum) ->
                        Comment.of(
                                rs.getLong("id"),
                                rs.getString("description"),
                                rs.getTimestamp("created_date_time").toLocalDateTime(),
                                rs.getLong("issue_id"),
                                rs.getLong("user_id"))
        , issueId);
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

    public void create(Long issueId, NewCommentDto newCommentDto) {
        String sql =
                "INSERT INTO comment(description, created_date_time, issue_id, user_id) " +
                        "VALUES(?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                newCommentDto.getDescription(),
                Timestamp.valueOf(LocalDateTime.now()),
                issueId,
                newCommentDto.getUserId());
    }
}

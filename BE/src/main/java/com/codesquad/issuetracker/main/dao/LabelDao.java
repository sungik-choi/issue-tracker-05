package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.main.dto.request.NewLabelDto;
import com.codesquad.issuetracker.main.domain.Label;
import com.codesquad.issuetracker.main.vo.labelVO.LabelSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabelDao {

    private static final Logger logger = LoggerFactory.getLogger(LabelDao.class);

    private JdbcTemplate jdbcTemplate;

    public LabelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Label> findAllLabels() {
        return jdbcTemplate.query(
                "SELECT label.id, label.name, label.description, label.background_color, label.color FROM label",
                (rs, rowNum) ->
                        Label.of(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"),
                                rs.getString("background_color"),
                                rs.getString("color"))
        );
    }

    public List<LabelSummary> findLabelSummariesByIssueId(Long issueId) {
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

    public void create(NewLabelDto newLabelDto) {
        String sql = "INSERT INTO label(name, description, background_color, color) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                newLabelDto.getTitle(),
                newLabelDto.getDescription(),
                newLabelDto.getBackgroundColor(),
                newLabelDto.getColor());
    }

    public void update(Integer labelId, NewLabelDto newLabelDto) {
        String sql = "UPDATE label SET name = ?, description = ?, background_color = ?, color = ? WHERE id = ?";
        jdbcTemplate.update(sql,
                newLabelDto.getTitle(), newLabelDto.getDescription(),
                newLabelDto.getBackgroundColor(), newLabelDto.getColor(), labelId);
    }

    public void delete(Integer labelId) {
        String sql = "DELETE FROM label WHERE id = ?";
        jdbcTemplate.update(sql, labelId);
    }
}

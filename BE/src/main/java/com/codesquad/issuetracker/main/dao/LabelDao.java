package com.codesquad.issuetracker.main.dao;

import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LabelDao {

    private final JdbcTemplate jdbcTemplate;

    public LabelDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        String sql = "SELECT l.id, l.name, l.background_color, l.color " +
                     "FROM label l JOIN issue_has_label il ON l.id = il.label_id " +
                     "WHERE il.issue_id = ?";
        return jdbcTemplate.query(sql, new Object[]{issueId},
                (rs, rowNum) -> new LabelSummary.Builder()
                                                .id(rs.getInt("l.id"))
                                                .name(rs.getString("l.name"))
                                                .backgroundColor(rs.getString("l.background_color"))
                                                .color("l.color")
                                                .build());
    }

    public List<Label> findAllLabels() {
        String sql = "SELECT id, name, description, background_color, color FROM label";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Label.Builder()
                                                                .id(rs.getInt("id"))
                                                                .name(rs.getString("name"))
                                                                .description(rs.getString("description"))
                                                                .backgroundColor(rs.getString("color"))
                                                                .color(rs.getString("color"))
                                                                .build());
    }
}

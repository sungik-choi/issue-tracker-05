package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LabelDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public LabelDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void createNewLabel(String labelName, String description, String hexCode) {
        String sql = "INSERT INTO label (name, description, hex_code) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,new Object[]{labelName, description, hexCode});
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        String sql = "SELECT l.id, l.name, l.hex_code " +
                     "FROM label l JOIN issue_has_label il ON l.id = il.label_id " +
                     "WHERE il.issue_id = ?";
        return jdbcTemplate.query(sql, new Object[]{issueId},
                (rs, rowNum) -> LabelSummary.of(rs.getInt("l.id"), rs.getString("l.name"),
                                                    rs.getString("l.hex_code")));
    }

    public List<Label> findAllLabels() {
        String sql = "SELECT id, name, description, hex_code FROM label";
        return jdbcTemplate.query(sql, (rs, rowNum) -> Label.create(rs.getInt("id"), rs.getString("name"),
                                                                    rs.getString("description"), rs.getString("hex_code")));
    }

    public void updateLabel(Integer labelId, String labelName, String description, String hexCode) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("labelId", labelId)
                                                .addValue("labelName", labelName)
                                                .addValue("description", description)
                                                .addValue("hexCode", hexCode);
        String sql = "UPDATE label SET name = :labelName, description = :description, hex_code = :hexCode WHERE id = :labelId";
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void deleteNewLabel(Integer labelId) {
        String sql = "DELETE FROM label WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{labelId});
    }
}

package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LabelDao_Ragdoll {

    private final JdbcTemplate jdbcTemplate;

    public LabelDao_Ragdoll(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
        String sql = "SELECT l.id, l.name, l.hex_code " +
                     "FROM label l JOIN issue_has_label il ON l.id = il.label_id " +
                     "WHERE il.issue_id = ?";
        return jdbcTemplate.query(sql, new Object[]{issueId},
                (rs, rowNum) -> LabelSummary.create(rs.getInt("l.id"), rs.getString("l.name"),
                                                    rs.getString("l.hex_code")));
    }

    public List<Label> findAllLabels() {
        String sql = "SELECT id, name, description, hex_code FROM label";
        return jdbcTemplate.query(sql, (rs, rowNum) -> Label.create(rs.getInt("id"), rs.getString("name"),
                                                                    rs.getString("description"), rs.getString("hex_code")));
    }
}

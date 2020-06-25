<<<<<<< HEAD
package com.codesquad.issuetracker.ragdoll.dao;

import com.codesquad.issuetracker.ragdoll.domain.Label;
import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelDetails;
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

    public void createNewLabel(String labelName, String description, String backgroundColor, String color) {
        String sql = "INSERT INTO label (name, description, background_color, color) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql,new Object[]{labelName, description, backgroundColor, color});
    }

    public List<LabelDetails> findAttachedLabelsByIssueId(Long issueId) {
        String sql = "SELECT l.id, l.name, l.background_color, l.color " +
                     "FROM label l JOIN issue_has_label il ON l.id = il.label_id " +
                     "WHERE il.issue_id = ?";
        return jdbcTemplate.query(sql, new Object[]{issueId},
                (rs, rowNum) -> new LabelDetails.Builder()
                                                .id(rs.getInt("l.id"))
                                                .name(rs.getString("l.name"))
                                                .backgroundColor(rs.getString("l.background_color"))
                                                .color(rs.getString("l.color"))
                                                .build());
    }

    public List<Label> findAllLabels() {
        String sql = "SELECT id, name, description, background_color, color FROM label";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Label.Builder().id(rs.getInt("id"))
                                                                          .name(rs.getString("name"))
                                                                          .description(rs.getString("description"))
                                                                          .backgroundColor(rs.getString("background_color"))
                                                                          .color(rs.getString("color"))
                                                                          .build());
    }

    public void updateLabel(Integer labelId, String labelName, String description, String backgroundColor, String color) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                                                .addValue("labelId", labelId)
                                                .addValue("labelName", labelName)
                                                .addValue("description", description)
                                                .addValue("backgroundColor", backgroundColor)
                                                .addValue("color", color);
        String sql = "UPDATE label SET name = :labelName, description = :description, " +
                                                         "background_color = :backgroundColor, " +
                                                         "color = :color " +
                     "WHERE id = :labelId";
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void deleteNewLabel(Integer labelId) {
        String sql = "DELETE FROM label WHERE id = ?";
        jdbcTemplate.update(sql, new Object[]{labelId});
    }
}
=======
//package com.codesquad.issuetracker.ragdoll.dao;
//
//import com.codesquad.issuetracker.ragdoll.domain.Label;
//import com.codesquad.issuetracker.ragdoll.vo.labelVO.LabelSummary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.List;
//
//@Repository
//public class LabelDao_Ragdoll {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public LabelDao_Ragdoll(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    public List<LabelSummary> findAttachedLabelsByIssueId(Long issueId) {
//        String sql = "SELECT l.id, l.name, l.hex_code " +
//                     "FROM label l JOIN issue_has_label il ON l.id = il.label_id " +
//                     "WHERE il.issue_id = ?";
//        return jdbcTemplate.query(sql, new Object[]{issueId},
//                (rs, rowNum) -> LabelSummary.create(rs.getInt("l.id"), rs.getString("l.name"),
//                                                    rs.getString("l.hex_code")));
//    }
//
//    public List<Label> findAllLabels() {
//        String sql = "SELECT id, name, description, hex_code FROM label";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> Label.create(rs.getInt("id"), rs.getString("name"),
//                                                                    rs.getString("description"), rs.getString("hex_code")));
//    }
//
//    public void find(UserDto userDto) {
//        INSERT userDto.id,
//    }
//}
>>>>>>> be/dev

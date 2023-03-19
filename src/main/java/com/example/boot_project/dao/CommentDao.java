package com.example.boot_project.dao;

import com.example.boot_project.entity.Comment;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class CommentDao extends BaseDao{
    public CommentDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }
    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists comments\n" +
                "(\n" +
                "    id       bigserial primary key,\n" +
                "    commentText     varchar,\n" +
                "    dateComment     timestamp,\n" +
                ");");
    }

    public List<Comment> getComments() {
        String sql = "select * from comments";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class));
    }

    public void saveComments(Comment comment) {
        String sql = "insert into comments(commentText) " +
                "values(?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, comment.getCommentText());
            return ps;
        });
    }

    public Optional<Comment> findById(Long commentId) {
        String sql = "select * " +
                "from comments " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Comment.class), commentId)
        ));
    }

    public void deleteAll() {
        String sql = "delete from comments";
        jdbcTemplate.update(sql);
    }


}

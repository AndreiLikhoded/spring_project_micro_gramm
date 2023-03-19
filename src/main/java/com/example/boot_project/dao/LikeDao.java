package com.example.boot_project.dao;

import com.example.boot_project.entity.Like;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Optional;

public class LikeDao extends BaseDao{

    public LikeDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists likes  \n" +
                "(\n" +
                "    id       bigserial primary key,\n" +
                "    likeAim     varchar,\n" +
                "    age         integer,\n" +
                "    dateOfLike  timestamp,\n" +
                ");");
    }

    public List<Like> geLikes() {
        String sql = "select * from likes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class));
    }

    public Optional<Like> findById(Long likeId) {
        String sql = "select * " +
                "from likes " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class),likeId)
        ));
    }

    public void deleteAll() {
        String sql = "delete from likes";
        jdbcTemplate.update(sql);
    }


}

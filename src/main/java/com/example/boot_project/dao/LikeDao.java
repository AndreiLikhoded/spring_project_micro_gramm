package com.example.boot_project.dao;

import com.example.boot_project.entity.Like;
import com.example.boot_project.entity.Publication;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
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
                "    dateOfLike  timestamp,\n" +
                ");");
    }

    public List<Like> geLikes() {
        String sql = "select * from likes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class));
    }
    public void update(Like like) {
        String sql = "update likes " +
                "set publication_id = :publication_id, " +
                "likeAim = :likeAim, " +
                "dateOfLike = :dateOfLike, " +
                "where id = :id";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("publication_id", like.getUserId())
                        .addValue("likeAim", like.getLikeAim())
                        .addValue("dateOfLIke", like.getDateOfLike())
                        .addValue("id", like.getId()));
    }


    public Optional<Like> findById(Long likeId) {
        String sql = "select * " +
                "from likes " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Like.class),likeId)
        ));
    }

    public void deleteById(Long likeId) {
        String sql = "delete from likes " +
                "where id = ?";
        jdbcTemplate.update(sql);
    }

    public void deleteAll() {
        String sql = "delete from likes";
        jdbcTemplate.update(sql);
    }

}

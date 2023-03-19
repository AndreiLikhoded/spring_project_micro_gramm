package com.example.boot_project.dao;

import com.example.boot_project.entity.Publication;
import com.example.boot_project.entity.Subscriber;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;


@Component
public class SubscriberDao extends BaseDao{

    public SubscriberDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists subcribers\n" +
                "(\n" +
                "    id bigserial          primary key,\n" +
                "    dateSubscriber        varchar,\n" +
                ");");
    }

    public List<Subscriber> getSubscribers() {
        String sql = "select * from subscribers";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscriber.class));
    }
    public Optional<Subscriber> findById(Long subscriberId) {
        String sql = "select * " +
                "from subscribers " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Subscriber.class), subscriberId)
        ));
    }

    public void deleteAll() {
        String sql = "delete from subscribers";
        jdbcTemplate.update(sql);
    }


}

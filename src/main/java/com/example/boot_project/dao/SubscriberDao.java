package com.example.boot_project.dao;

import com.example.boot_project.entity.Publication;
import com.example.boot_project.entity.Subscriber;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class SubscriberDao extends BaseDao{

    public SubscriberDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists subscribers\n" +
                "(\n" +
                "    id bigserial          primary key,\n" +
                "    dateSubscriber        varchar\n" +
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
    public void update(Subscriber subscriber) {
        String sql = "update subscribe " +
                "set user_id = :user_id, " +
                "userSubscribeTo = :userSubscribeTo, " +
                "userSubscriberId = :userSubscriberId, " +
                "dateSubscribe = :dateSubscribe " +
                "where id = :id";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource("userSubscriberTo", subscriber.getSubscriberTo())
                        .addValue("userSubscriberId", subscriber.getUserSubscriberId())
                        .addValue("dateSubscribe", subscriber.getDateSubscribe()));

    }

    public void deleteAll() {
        String sql = "delete from subscribers";
        jdbcTemplate.update(sql);
    }


}

package com.example.boot_project.dao;

import com.example.boot_project.entity.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserDao extends BaseDao{

    public UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public Optional<User> findByName(String accountName) {
        String sql = "select * " +
                "from users " +
                "where accountName = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), accountName)
        ));
    }

    public Optional<User> findByEmail(String email) {
        String sql = "select * " +
                "from users " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));
    }

    public Optional<User> findByLogin(String login) {
        String sql = "select * " +
                "from users " +
                "where login = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), login)
        ));
    }


}

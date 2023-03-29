package com.example.boot_project.dao;

import com.example.boot_project.entity.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Component
public class UserDao extends BaseDao{


    public UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    public Optional<User> findByName(String accountName) {
        String sql = "select * " +
                "from usr " +
                "where accountName = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), accountName)
        ));
    }

    public Optional<User> findByEmail(String email) {
        String sql = "select * " +
                "from usr " +
                "where email = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), email)
        ));
    }

    public Optional<User> findByLogin(String login) {
        String sql = "select * " +
                "from usr " +
                "where login = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), login)
        ));
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists usr\n" +
                "(\n" +
                "    id       bigserial primary key,\n" +
                "    name     varchar,\n" +
                "    age      integer,\n" +
                "    login    varchar,\n" +
                "    email    varchar\n" +

                ");");
    }
    public List<User> findAll() {
        String sql = "select * from usr";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public void saveAll(List<User> users) {
        String sql = "insert into usr(email, name) " +
                "values(?,?)";

        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, users.get(i).getEmail());
                ps.setString(2, users.get(i).getName());
            }

            public int getBatchSize() {
                return users.size();
            }
        });


    }

        public void deleteAll() {
        String sql = "delete from usr";
        jdbcTemplate.update(sql);
    }

}

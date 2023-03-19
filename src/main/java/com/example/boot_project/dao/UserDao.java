package com.example.boot_project.dao;

import com.example.boot_project.entity.User;
import com.example.boot_project.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.sql.*;




@Component
public class UserDao extends BaseDao{

    private Connection conn;
    private HomeService homeService;


    public UserDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
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
    public void createTable() throws SQLException {
        String userTableQuery = "create table users (" +
                "id integer primary key," +
                "name varchar(40)," +
                "age integer)";
        String userEntryQuery = "insert into users(id, name, age)" +
                "values(1, 'Andrei', 33)";

        homeService.executeUpdate(userTableQuery);
        homeService.executeUpdate(userEntryQuery);
    }

    public void deleteAll() {
        String sql = "delete from usr";
        jdbcTemplate.update(sql);
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


}

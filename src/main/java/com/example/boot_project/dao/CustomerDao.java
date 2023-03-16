package com.example.boot_project.dao;

import com.example.boot_project.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomers() {
        String sql = "select * from customers";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }
}

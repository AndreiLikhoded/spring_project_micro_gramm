package com.example.boot_project.dao;

import com.example.boot_project.entity.Comment;
import com.example.boot_project.entity.Publication;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class PublicationDao extends BaseDao{

    public PublicationDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Override
    public void createTable() {
        jdbcTemplate.execute("create table if not exists publications\n" +
                "(\n" +
                "    id       bigserial primary key,\n" +
                "    comment               varchar,\n" +
                "    image                 varchar,\n" +
                "    description           varchar,\n" +
                "    dateOfPublication     timestamp,\n" +
                ");");
    }

    public List<Publication> getPublications() {
        String sql = "select * from publications";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Publication.class));
    }

    public void savePublications(Publication publication) {
        String sql = "insert into publications(image, description) " +
                "values(?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, publication.getImage());
            ps.setString(2, publication.getDescription());
            return ps;
        });
    }

    public Optional<Publication> findById(Long publicationId) {
        String sql = "select * " +
                "from publications " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Publication.class), publicationId)
        ));
    }

    public void deleteAll() {
        String sql = "delete from publications";
        jdbcTemplate.update(sql);
    }

}

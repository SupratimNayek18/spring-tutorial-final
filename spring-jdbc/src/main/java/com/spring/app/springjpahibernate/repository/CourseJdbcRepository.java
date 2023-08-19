package com.spring.app.springjpahibernate.repository;

import com.spring.app.springjpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY="insert into course values(?,?,?)";

    private static String DELETE_QUERY = "delete from course where id=?";

    private static String FIND_BY_ID = "select * from course where id=?";

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void delete(Integer id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(Integer id){
        return jdbcTemplate.queryForObject(FIND_BY_ID,new BeanPropertyRowMapper<>(Course.class),id);
    }

}

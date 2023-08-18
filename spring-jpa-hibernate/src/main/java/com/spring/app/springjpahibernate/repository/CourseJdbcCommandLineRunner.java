package com.spring.app.springjpahibernate.repository;

import com.spring.app.springjpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1,"Spring JDBC","Supratim"));
        courseJdbcRepository.insert(new Course(2,"Spring Data Jpa","Supratim"));
        courseJdbcRepository.insert(new Course(3,"Spring Cloud","Supratim"));
        courseJdbcRepository.insert(new Course(4,"Spring Security","Supratim"));
        courseJdbcRepository.insert(new Course(5,"Spring Boot","Supratim"));
        courseJdbcRepository.delete(1);
        System.out.println(courseJdbcRepository.findById(2));
        System.out.println(courseJdbcRepository.findById(3));
    }
}

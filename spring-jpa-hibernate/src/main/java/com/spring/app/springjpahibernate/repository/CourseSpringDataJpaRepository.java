package com.spring.app.springjpahibernate.repository;

import com.spring.app.springjpahibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long> {

    public List<Course> findByAuthor(String author);

}

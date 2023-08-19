package com.spring.app.springjpahibernate.repository;

import com.spring.app.springjpahibernate.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

//simple jpa repository

@Repository
@Transactional
public class CourseJPARepository {

    @PersistenceContext //more specific than autowired
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public Course findById(long id){
        return entityManager.find(Course.class,id);
    }

    public void deleteById(long id){
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

}

package com.spring.app.springjpahibernate.repository;

import com.spring.app.springjpahibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJPARepository courseJPARepository;

    @Autowired
    private CourseSpringDataJpaRepository courseSpringDataJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        courseJPARepository.insert(new Course(1,"Spring JDBC","Supratim JPA"));
//        courseJPARepository.insert(new Course(2,"Spring Data Jpa","Supratim JPA"));
//        courseJPARepository.insert(new Course(3,"Spring Cloud","Supratim"));
//        courseJPARepository.insert(new Course(4,"Spring Security","Supratim"));
//        courseJPARepository.insert(new Course(5,"Spring Boot","Supratim"));
//        courseJPARepository.deleteById(1);
//        System.out.println(courseJPARepository.findById(2));
//        System.out.println(courseJPARepository.findById(3));

        courseSpringDataJpaRepository.save(new Course(1,"Spring JDBC","Supratim Spring Data JPA"));
        courseSpringDataJpaRepository.save(new Course(2,"Spring Data Jpa","Supratim Spring Data JPA"));
        courseSpringDataJpaRepository.save(new Course(3,"Spring Cloud","Supratim"));
        courseSpringDataJpaRepository.save(new Course(4,"Spring Security","Supratim"));
        courseSpringDataJpaRepository.save(new Course(5,"Spring Boot","Supratim"));
        courseSpringDataJpaRepository.deleteById(1L);
        System.out.println(courseSpringDataJpaRepository.findById(2L));
        System.out.println(courseSpringDataJpaRepository.findById(3L));

        courseSpringDataJpaRepository.findAll().forEach(System.out::println);

        courseSpringDataJpaRepository.findByAuthor("Supratim").forEach(System.out::println);
    }
}

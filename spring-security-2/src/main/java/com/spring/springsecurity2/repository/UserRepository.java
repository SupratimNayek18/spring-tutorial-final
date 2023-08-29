package com.spring.springsecurity2.repository;

import com.spring.springsecurity2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
}

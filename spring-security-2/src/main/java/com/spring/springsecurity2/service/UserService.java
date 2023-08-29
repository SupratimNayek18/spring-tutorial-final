package com.spring.springsecurity2.service;

import com.spring.springsecurity2.model.User;
import com.spring.springsecurity2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public UserService(){}

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userName){
        return userRepository.findByUserName(userName);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}

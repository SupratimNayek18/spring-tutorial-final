package com.spring.app;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

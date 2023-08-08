package com.spring.app;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class User {

    String name;
    int age;

    // you cannot use this constructor as spring will try to inject String class dependency
//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

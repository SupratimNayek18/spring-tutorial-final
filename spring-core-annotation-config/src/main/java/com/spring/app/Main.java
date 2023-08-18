package com.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        User user1 = (User) context.getBean(User.class);
        User user2 = (User) context.getBean(User.class);

        UserService userService = (UserService) context.getBean(UserService.class);

        user1.setAge(23);
        user1.setName("Supratim");

        user2.setName("Shreyas");
        user2.setAge(22);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        userService.setUserList(list);

        userService.getUserList().forEach(i-> System.out.println(i.getName()));

        Student student = (Student) context.getBean(Student.class);

        student.setName("Supratim");

        System.out.println(student.getName()+" : "+student.getSchool().getName());

    }
}

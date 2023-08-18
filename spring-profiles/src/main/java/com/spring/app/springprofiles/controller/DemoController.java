package com.spring.app.springprofiles.controller;

import com.spring.app.springprofiles.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    ApplicationConfig applicationConfig;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getInfo")
    public ApplicationConfig getInfo(){
        return applicationConfig;
    }

}

package com.springmvc.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String welcome(){
        return "index";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model){
        model.addAttribute("message","Welcome To Spring MVC");
        List<String> list = new ArrayList<>();
        list.add("Supratim");
        list.add("Shreyas");
        model.addAttribute("list",list);
        return "hello_world";
    }
}

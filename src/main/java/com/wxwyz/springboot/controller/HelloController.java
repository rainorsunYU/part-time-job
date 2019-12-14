package com.wxwyz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String toIndex() {
//        return "index";
//    }

    @GetMapping(value = "/user/login")
    public String toLogin(Map<String, Object> map) {
        map.put("hello", "login");
        return "login";
    }
//
//    @RequestMapping("/login")
//    public String login(Map<String, Object> map) {
//        map.put("hello" ,"你好");
//        return "login";
//    }
}

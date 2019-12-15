package com.wxwyz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BusinessController {



    @RequestMapping(value = "/user/info",params = "businessId")
    public String findUserInfo(){


        return "userInfo";
    }
}

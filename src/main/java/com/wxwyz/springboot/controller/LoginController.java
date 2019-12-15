package com.wxwyz.springboot.controller;

import com.wxwyz.springboot.domain.Business;
import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.service.impl.BusinessServiceImpl;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BusinessServiceImpl businessServiceImpl;

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @RequestMapping(value = "/business/home")
    public String businessHome(HttpServletRequest request, Model model){
        Business business = (Business) request.getSession().getAttribute("businessLogin");
        List<Job> jobLists = jobServiceImpl.findJobByAccount( business.getAccount() );
//        request.getSession().setAttribute("jobList",jobList);
        model.addAttribute("jobLists",jobLists);
//        return "redirect:/main.html";
//        return "index";
        return "business";
    }

    @ResponseBody
    @PostMapping("/business/login")
    public String loginVerify(@RequestParam("user_login") String userLogin,
                              @RequestParam("pwd_login") String pwdLogin, HttpServletRequest request) {

        Business business = new Business();
        business.setAccount(userLogin);
        business.setPassword(pwdLogin);
        request.getSession().setAttribute("businessLogin", business);

        String result = String.valueOf(businessServiceImpl.queryAccountForLogin(business));
        return result;
    }


}

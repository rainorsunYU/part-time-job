package com.wxwyz.springboot.controller;

import com.wxwyz.springboot.domain.Business;
import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.domain.Student;
import com.wxwyz.springboot.service.impl.BusinessServiceImpl;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import com.wxwyz.springboot.service.impl.StudentServiceImpl;
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

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @RequestMapping(value = "/business/home")
    public String businessHome(HttpServletRequest request, Model model){
        Business business = (Business) request.getSession().getAttribute("businessLogin");
        List<Job> jobLists = jobServiceImpl.findJobByAccount( business.getAccount() );
        model.addAttribute("jobLists",jobLists);
//        return "redirect:/main.html";
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


    @ResponseBody
    @PostMapping("/student/login")
    public String loginStuVerify(@RequestParam("user_login") String userLogin,
                              @RequestParam("pwd_login") String pwdLogin, HttpServletRequest request) {


        Student student = new Student();
        student.setStuAccount(userLogin);
        student.setStuPassword(pwdLogin);
        request.getSession().setAttribute("studentLogin", student);

        String result = String.valueOf(studentServiceImpl.findStudent(student));
        return result;
    }

    @RequestMapping(value = "/student/home")
    public String studentHome(HttpServletRequest request, Model model){
        List<Job> allJobLists = jobServiceImpl.findAllJob();
        model.addAttribute("allJobLists",allJobLists);

        return "student";
    }

}

package com.wxwyz.springboot.controller;

import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BusinessController {

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @RequestMapping(value = "/user/info")
    public String findUserInfo(@RequestParam("businessId") String businessId,
                               Model model){

        Integer jobId = Integer.parseInt(businessId);
        Job jobInfo = jobServiceImpl.findBusinessJob(jobId);
        model.addAttribute("jobInformation",jobInfo);

        return "jobInfo";
    }
}

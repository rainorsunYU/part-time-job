package com.wxwyz.springboot.controller;

import com.wxwyz.springboot.domain.Business;
import com.wxwyz.springboot.domain.Comment;
import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.service.impl.CommentServiceImpl;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class BusinessController {

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @RequestMapping(value = "/user/info")
    public String findUserInfo(@RequestParam("businessId") String businessId,
                               @RequestParam("jobId") String jobId,
                               Model model) {

        Integer aJobId = Integer.parseInt(jobId);
        jobServiceImpl.updateViews(aJobId);
        jobServiceImpl.findComments(aJobId);
        Job jobInfo = jobServiceImpl.findBusinessJob(aJobId);
        model.addAttribute("jobInformation", jobInfo);

        List<Comment> comments = commentServiceImpl.queryComment(businessId, Integer.parseInt(jobId));

        model.addAttribute("comments",comments);

        return "jobInfo";
    }

    @ResponseBody
    @PostMapping("/business/upload")
    public String uploadJob(@RequestParam("title") String title,
                            @RequestParam("counts") String counts,
                            @RequestParam("hours") String hours,
                            @RequestParam("select_time") String selectTime,
                            @RequestParam("salary") String salary,
                            @RequestParam("select_date") String selectDate,
                            @RequestParam("select_address") String selectAddress,
                            @RequestParam("content") String content,
                            HttpServletRequest request,
                            Model model) {

        String salarys = salary + selectDate;
        String jobTitle = title;
        String working = hours + selectTime;
        String address = selectAddress;
        Job job = new Job();
        Business business = (Business) request.getSession().getAttribute("businessLogin");

        job.setJobPublisher(business.getAccount());
        job.setJobTitle(jobTitle);
        job.setUserCounts(Integer.parseInt(counts));
        job.setJobSalary(salarys);
        job.setJobLocation(address);
        job.setWorkingHours(working);
        job.setJobContent(content);
//        job.setComments(jobServiceImpl.findComments());
        job.setJobReleaseTime(new Date());
        String result = String.valueOf(jobServiceImpl.postAJob(job));
//        List<Job> jobLists = jobServiceImpl.findJobByAccount(business.getAccount());
//        model.addAttribute("jobLists", jobLists);

        return result;

    }

    @RequestMapping(value = "/business/exit")
    public String businessExit(HttpServletRequest request) {
        request.getSession().removeAttribute("businessLogin");
        return "redirect:/";
    }
}

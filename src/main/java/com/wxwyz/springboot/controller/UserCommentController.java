package com.wxwyz.springboot.controller;

import com.wxwyz.springboot.domain.Comment;
import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.service.impl.CommentServiceImpl;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserCommentController {

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @ResponseBody
    @GetMapping("/user/comment")
    public String comment(@RequestParam("comment") String comment,
                          @RequestParam("jobId") String jobId,
                          @RequestParam("busId") String busId,
                          @RequestParam("userId") String userId) {

        Comment userComment = new Comment();
        userComment.setJobId(Integer.parseInt(jobId));
        userComment.setCommentParentId(busId);
        userComment.setCommentUserId(userId);
        userComment.setCommentContent(comment);

        String result = String.valueOf(commentServiceImpl.insertComment(userComment));

        int counts = jobServiceImpl.findComments(Integer.parseInt(jobId));
        Job job = new Job();
        job.setJobId(Integer.parseInt(jobId));
        job.setComments(counts);
        jobServiceImpl.updateComments(job);

        return result;
    }
}

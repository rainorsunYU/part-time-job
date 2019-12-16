package com.wxwyz.springboot;

import com.wxwyz.springboot.domain.Business;
import com.wxwyz.springboot.domain.Comment;
import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.mapper.CommentMapper;
import com.wxwyz.springboot.mapper.JobMapper;
import com.wxwyz.springboot.mapper.StudentMapper;
import com.wxwyz.springboot.service.impl.BusinessServiceImpl;
import com.wxwyz.springboot.service.impl.JobServiceImpl;
import com.wxwyz.springboot.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MySpringBoot04ApplicationTests {

    @Autowired
    private BusinessServiceImpl businessServiceImpl;

    @Autowired
    private JobServiceImpl jobServiceImpl;

//    @Autowired
//    private BusinessMapper businessMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private JobMapper jobMapper;

    @Test
    void contextLoads() {
        Business business = new Business();
        business.setAccount("business0001");
        business.setPassword("123456");
        System.out.println(businessServiceImpl.queryAccountForLogin(business));
//        Business business = businessMapper.queryBusinessByAccount("business0001");
//        System.out.println(business.getPassword());
    }

    @Test
    void test02() {

        List<Job> jobs = jobServiceImpl.findAllJob();
        for (Job job : jobs) {
            System.out.println(job.getJobPublisher());
        }
    }

    @Test
    void test03() {
        Job job = new Job();
        job.setJobPublisher("吴彦祖");
        job.setJobTitle("我是兼职一");
        job.setJobContent("扫垃圾");
        job.setWorkingHours("6小时");
        job.setJobSalary("600每天");
        job.setJobLocation("皖西学院");
        job.setJobReleaseTime(new Date());
        System.out.println(jobServiceImpl.postAJob(job));
    }

    @Autowired
    private StudentServiceImpl studentServiceImpl;


    @Autowired
    private StudentMapper studentMapper;

    @Test
    void test003() {
        Job job = new Job();
        job.setJobId(1);
        job.setComments(10);
        System.out.println(jobMapper.updateComments(job));
    }

    @Test
    void test00123() {
       List<Comment> list = commentMapper.queryCommentByBusinessId("business0001",1);
        for (Comment comment : list) {
            System.out.println(comment);
        }
    }

}

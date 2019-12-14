package com.wxwyz.springboot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Job {

    private Integer jobId;
    private String jobPublisher;
    private String jobTitle;
    private String jobContent;
    private Integer userCounts;
    private String workingHours;
    private Double jobSalary;
    private String jobLocation;
    private Date jobReleaseTime;
    private Integer likes;
    private Integer views;
    private Integer comments;

}

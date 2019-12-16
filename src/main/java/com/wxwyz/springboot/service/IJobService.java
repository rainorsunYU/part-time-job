package com.wxwyz.springboot.service;

import com.wxwyz.springboot.domain.Job;

import java.util.List;

public interface IJobService {

    public List<Job> findAllJob();

    public List<Job> findJobByAccount(String name);

    public Job findBusinessJob(Integer jobId);

    public int postAJob(Job job);
}

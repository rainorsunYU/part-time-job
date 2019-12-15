package com.wxwyz.springboot.service.impl;

import com.wxwyz.springboot.domain.Job;
import com.wxwyz.springboot.mapper.JobMapper;
import com.wxwyz.springboot.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements IJobService {

    @Autowired
    private JobMapper jobMapper;

    @Transactional
    @Override
    public List<Job> findAllJob() {
        return jobMapper.queryAllJob();
    }

    @Transactional
    @Override
    public List<Job> findJobByAccount(String name) {
        List<String> list = jobMapper.queryAllPublisher();
        List<Job> jobList = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(name)){
                jobList = jobMapper.queryJobByName(name);
            }
        }
        return jobList;
    }

    @Transactional
    @Override
    public int postAJob(Job job) {
        return jobMapper.insertJob(job);
    }
}

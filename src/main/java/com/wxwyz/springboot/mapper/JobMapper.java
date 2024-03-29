package com.wxwyz.springboot.mapper;

import com.wxwyz.springboot.domain.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface JobMapper {

    public List<String> queryAllPublisher();

    public List<Job> queryJobByNameDesc(String name);

    public Job queryJobById(Integer jobId);

    public List<Job> queryAllJob();

    public int insertJob(Job job);

    public int updateViews(Integer id);

    public int findComments(Integer id);

    public Integer updateComments(Job job);

}

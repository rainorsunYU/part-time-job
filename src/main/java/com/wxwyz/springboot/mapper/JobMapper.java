package com.wxwyz.springboot.mapper;

import com.wxwyz.springboot.domain.Job;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface JobMapper {

    public List<Job> queryAllJob();

    public int insertJob(Job job);

}
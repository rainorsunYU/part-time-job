package com.wxwyz.springboot.service;

import com.wxwyz.springboot.domain.Comment;

import java.util.List;

public interface ICommentService {

    public int insertComment(Comment comment);

    public List<Comment> queryComment(String businessId,Integer jobId);
}

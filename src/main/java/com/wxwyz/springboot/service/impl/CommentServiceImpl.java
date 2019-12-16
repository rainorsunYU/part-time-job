package com.wxwyz.springboot.service.impl;

import com.wxwyz.springboot.domain.Comment;
import com.wxwyz.springboot.mapper.CommentMapper;
import com.wxwyz.springboot.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Transactional
    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    @Transactional
    @Override
    public List<Comment> queryComment(String businessId, Integer jobId) {
        return commentMapper.queryCommentByBusinessId(businessId,jobId);
    }
}

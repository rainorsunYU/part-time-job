package com.wxwyz.springboot.mapper;

import com.wxwyz.springboot.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommentMapper {

    @Insert("insert into comment(job_id,comment_parent_id,comment_user_id,comment_content,business_comment)" +
            " values(#{jobId},#{commentParentId},#{commentUserId},#{commentContent},#{businessComment})")
    public int insertComment(Comment comment);

    @Select("select * from comment where comment_parent_id=#{businessId} and job_id=#{jobId}")
    public List<Comment> queryCommentByBusinessId(String businessId,Integer jobId);
}

package com.wxwyz.springboot.domain;

import lombok.Data;

@Data
public class Comment {

    private Integer commentId;
    private Integer jobId;
    private String commentParentId;
    private String commentUserId;
    private String commentContent;
    private String businessComment;

}

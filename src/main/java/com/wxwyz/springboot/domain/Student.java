package com.wxwyz.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {

    private Integer stuId;
    private String stuAccount;
    private String stuPassword;
    private Integer stuAge;
    private String stuSex;
    private String stuUniversity;
    private String stuContact;
    private String stuName;

}

package com.wxwyz.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Business implements Serializable {

    private Integer businessId;
    private String account;
    private String password;
    private String businessName;
    private String address;
    private String contact;
}

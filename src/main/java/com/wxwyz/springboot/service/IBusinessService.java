package com.wxwyz.springboot.service;

import com.wxwyz.springboot.domain.Business;

public interface IBusinessService {


    public int queryAccountForLogin(Business business);

    public int insertAccount(Business business);

    public int updateAccount(Business business);

    public int deleteAccount(String account);
}

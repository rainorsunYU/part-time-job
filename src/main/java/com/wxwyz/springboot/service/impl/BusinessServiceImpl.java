package com.wxwyz.springboot.service.impl;

import com.wxwyz.springboot.domain.Business;
import com.wxwyz.springboot.mapper.BusinessMapper;
import com.wxwyz.springboot.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Transactional
    @Override
    public int queryAccountForLogin(Business business) {
        List<String> list = businessMapper.queryAllAccount();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(business.getAccount())){
                if (business.getPassword().equals(businessMapper.queryBusinessByAccount(business.getAccount()).getPassword())){
                    return 0;//表示用户存在且对应的密码是正确的
                }else {
                    return 1;//表示密码错误
                }
            }
        }
        return -1;//表示用户不存在
    }

    @Override
    public int insertAccount(Business business) {
        return 0;
    }

    @Override
    public int updateAccount(Business business) {
        return 0;
    }

    @Override
    public int deleteAccount(String account) {
        return 0;
    }
}

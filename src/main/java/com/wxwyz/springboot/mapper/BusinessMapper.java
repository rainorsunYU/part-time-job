package com.wxwyz.springboot.mapper;

import com.wxwyz.springboot.domain.Business;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BusinessMapper {

   //查询所有的商家信息
    @Select("select * from business")
    public List<Business> queryAll();

    //查询所有已注册过的商家账户
    @Select("select account from business")
    public List<String> queryAllAccount();

    //通过账户查询商家信息
    @Select("select * from business where account=#{account}")
    public Business queryBusinessByAccount(String account);

    //通过商家名称查询商家
    @Select("select * from business where business_name=#{businessName}")
    public List<Business> queryBusinessByName(String name);

//    @Select("select * from accounts where username=")
//    public List<AccountBean> queryAccountByCondition(AccountBean accountBean);

    @Options(useGeneratedKeys = true,keyProperty = "business_id")
    @Insert("insert into business(account,password,business_name,address,contact) value(#{account},#{password},#{businessName},#{address},#{contact})")
    public int insertAccount();

    @Update("update business set password=#{password},business_name=#{businessName},address=#{address}contact=#{contact}")
    public int updateAccount();

    @Delete("delete from business where account=#{account}")
    public int deleteAccount(String username);
}

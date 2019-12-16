package com.wxwyz.springboot.mapper;

import com.wxwyz.springboot.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {

    @Select("select * from student")
    public List<Student> queryAllStudent();

    @Select("select stu_account from student")
    public List<String> queryAllStudentAccount();

    @Select("select * from student where stu_name=#{stuName}")
    public List<Student>  queryStudentByName(String stuName);

    @Select("select * from student where stu_account=#{stuAccount}")
    public Student queryStudentByAccount(String stuAccount);

}

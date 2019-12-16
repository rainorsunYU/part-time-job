package com.wxwyz.springboot.service.impl;

import com.wxwyz.springboot.domain.Student;
import com.wxwyz.springboot.mapper.StudentMapper;
import com.wxwyz.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int findStudent(Student student) {
        String account = student.getStuAccount();
        String password = student.getStuPassword();
        Student student1 = studentMapper.queryStudentByAccount(account);
        if (student1 !=  null){
           return student1.getStuPassword().equals(password)==true?1:0;
        }
        return -1;
    }
}

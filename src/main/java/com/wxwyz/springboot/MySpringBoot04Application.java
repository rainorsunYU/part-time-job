package com.wxwyz.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wxwyz.springboot")
//@EnableTransactionManagement
@MapperScan("com.wxwyz.*.mapper")
public class MySpringBoot04Application {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBoot04Application.class, args);
    }

}

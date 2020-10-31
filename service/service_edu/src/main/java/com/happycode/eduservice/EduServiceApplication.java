package com.happycode.eduservice;

import com.happycode.eduservice.service.EduTeacherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: ljl
 * @date: 2020/10/31 13:42
 * @description:
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.happycode"})
public class EduServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class,args);
    }
}

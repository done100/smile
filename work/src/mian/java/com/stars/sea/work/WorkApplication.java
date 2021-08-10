package com.stars.sea.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class,args);
    }
}

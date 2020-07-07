package com.jie.stupiddog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jie.stupiddog.dao")
public class StupiddogApplication {

    public static void main(String[] args) {
        SpringApplication.run(StupiddogApplication.class, args);
    }

}

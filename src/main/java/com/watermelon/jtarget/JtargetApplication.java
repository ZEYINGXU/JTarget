package com.watermelon.jtarget;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.watermelon.jtarget.**.dao")
@SpringBootApplication
public class JtargetApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtargetApplication.class, args);
    }

}

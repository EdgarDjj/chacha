package com.ttt.chacha.chacha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ttt.chacha.chacha.dao.")
@SpringBootApplication
public class ChachaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChachaApplication.class, args);
    }

}

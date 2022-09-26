package com.example.chap01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @SpringBootConfiguration + EnableAutoConfiguration + ComponentScan
public class Chapter1Application {
    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }
}

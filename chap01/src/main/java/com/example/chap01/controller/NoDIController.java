package com.example.chap01.controller;

import com.example.chap01.service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoDIController {

    private MyService service = new MyService();

    @GetMapping("/no-di/hello")
    public String getHello(){
        return service.getHello();
    }
}

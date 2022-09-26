package com.example.chap01.controller;

import com.example.chap01.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldInjectionController {
    @Autowired
    private MyService myservice;
}

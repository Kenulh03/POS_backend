package com.ijse.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")//localhost:8080/hello
    public String sayHello(){
        return "Hello Spring Boot";
    }
}

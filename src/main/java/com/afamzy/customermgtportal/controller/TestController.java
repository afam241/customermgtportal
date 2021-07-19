package com.afamzy.customermgtportal.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal")
public class TestController {
    @GetMapping("/test")
    public String testApi(){
        return "Hi, i am afam..." +
                "how are you boo?";
    }
}

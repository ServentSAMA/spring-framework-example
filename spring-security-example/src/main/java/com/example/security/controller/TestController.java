package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 申
 * @date 2023/4/13
 * @since 1.0
 */
@RestController
public class TestController {

    @GetMapping("/getName")
    public String getName(String name){
        return "您的名字是：" + name;
    }
    @GetMapping("/getId")
    public String getId(String id){
        return "您的身份是：" + id;
    }
}

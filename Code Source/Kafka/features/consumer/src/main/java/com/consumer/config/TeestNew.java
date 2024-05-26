package com.consumer.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeestNew {
    @GetMapping("/consumer/hello")
    public String show(){
        return "consumer";
    }
}

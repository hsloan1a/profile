package com.test.profile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
public class HelloWorld {

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    @GetMapping("/hello")
    public String HelloWorld() {
        return "hello world " + activeProfiles;
    }

}

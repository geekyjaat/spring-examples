package com.barley.cloud.controller;

import com.barley.cloud.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingController {

    @Autowired
    private Greeting greeting;

    @RequestMapping("/greet")
    public String greet() {
        return String.format("Hi there!!!! %s", greeting.getDefaultValue());
    }
}

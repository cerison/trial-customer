package com.chernet.trial.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping(value = "/hello")
    public String helloWorld(){
        return "Hello world";
    }

}
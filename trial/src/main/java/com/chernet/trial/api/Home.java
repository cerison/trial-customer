package com.chernet.trial.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {
    @GetMapping
    public String home(){
        return "Welcome to My Trial Application " + new Date();
    }
}

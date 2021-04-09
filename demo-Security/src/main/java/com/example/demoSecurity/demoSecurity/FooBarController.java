package com.example.demoSecurity.demoSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

    @GetMapping("/foo")
    public String getFoo(){
        return "Hello Foo";
    }

    @GetMapping("/bar")
    public String getBar(){
        return "Hello Bar";
    }
}

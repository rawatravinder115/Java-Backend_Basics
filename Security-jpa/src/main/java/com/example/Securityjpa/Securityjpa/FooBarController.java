package com.example.Securityjpa.Securityjpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {
    @GetMapping("/foo")
    public String getFoo(){
        return "Hello Foo";
    }

//    my_role1 -> /foo*
//    my_role2 -> /bar*, /foo*

    @GetMapping("/bar")
    public String getBar(){
        return "Hello Bar";
    }

    // this api  require authentication and authorization as well
    @GetMapping("/student")
    public String getStudent(){
        return "Hello Student";
    }

    // this api  require authentication and authorization as well
    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello Admin";
    }

    // this api does not require authentication and authorization
    @GetMapping("/visitor")
    public String getVisitor(){
        return "Hello Visitor";
    }
}

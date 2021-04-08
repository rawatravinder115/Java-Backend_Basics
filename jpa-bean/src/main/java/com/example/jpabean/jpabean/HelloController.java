package com.example.jpabean.jpabean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloWorld helloWorld;

    @GetMapping("/func")
    public void func(){
        System.out.println(helloWorld);
    }
    // http://localhost:8080/func
    // for this we have to request for the print through client(chrome , postman ).
}

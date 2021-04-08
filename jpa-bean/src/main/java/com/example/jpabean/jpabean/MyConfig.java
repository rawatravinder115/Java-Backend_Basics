package com.example.jpabean.jpabean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
//    @Scope("prototype")  // this annotation will give new object every time when we the bean is calling rather than
    // giving only one object
    public HelloWorld getHelloWorldObject(){
        return new HelloWorld("this is an object","grabage data");
    }
}

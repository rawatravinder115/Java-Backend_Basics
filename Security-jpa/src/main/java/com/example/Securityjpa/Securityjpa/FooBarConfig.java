package com.example.Securityjpa.Securityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                // use this to convert html response to json.(used for postman)
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("admin") // this is used to match api // ** these star means after /admin/**
                .antMatchers("/student/**").hasAnyAuthority("student","admin")// checking as a Authorities.
                .antMatchers("/**").permitAll() // it will not asked anyone for  username and password.
                .and()
                .formLogin(); // provide you a basic login page.
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    for costumize PasswordEncoder

//    @Autowired
//    MyPasswordEncoder encoder;
//
//    @Bean
//    public MyPasswordEncoder getMyPasswordEncoder(){
//        return encoder;
//    }


}

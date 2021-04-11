package com.example.demoSecurity.demoSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class FooBarConfig extends WebSecurityConfigurerAdapter {

//    allows you to use different type of authentication.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().
                withUser("ravinder")
                .password("root")
                .roles("admin_role1"/*,"student_role2"*/) // this user can user these 2 api.
                .and()  // use to define another user
                .withUser("ravi")
                .password("ravi_root")
                .roles("student_role");

        // your data will be lost after the server is stop.

        //     auth.userDetailsService();
    }


    //    this is for authorization purpose
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic()
                // use this to convert html response to json.(used for postman)
                .and()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("admin_role") // this is used to match api // ** these star means after /admin/**
            .antMatchers("/student/**").hasAnyRole("admin_role","student_role")
            .antMatchers("/**").permitAll() // it will not asked anyone for  username and password.
            .and()
            .formLogin(); // provide you a basic login page.
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return  NoOpPasswordEncoder.getInstance( );
    }

//     whenever you are defining a authentication and Authirization function you also need to
//    define PasswordEncoder Bean because app dont store the password in the simplw form so it decode it.
}

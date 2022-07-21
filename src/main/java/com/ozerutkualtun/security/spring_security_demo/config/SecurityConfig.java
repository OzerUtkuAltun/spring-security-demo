package com.ozerutkualtun.security.spring_security_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // adding a reference to our security datasource

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(securityDataSource);

    }

    // bu metod login formu customize etmek için kullanılacak
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Not: restrict based bir yapı kurduğumuz için .anyRequest().authenticated()'e gerek kalmadı

        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin() // customizing login page.
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateUser")  // Login form should POST data to this URL for processing. Development not required. Spring security handle this :)
                .permitAll() // Everyone can see the login form.
                .and()
                .logout()  // default -> /logout
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}

package com.ozerutkualtun.security.spring_security_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // not: User.withDefaultPasswordEncoder is deprecated.

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("utku").password("test123").roles("ADMIN", "EMPLOYEE","MANAGER"))
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("susan").password("test123").roles("EMPLOYEE", "MANAGER"));
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
                .permitAll();
    }
}

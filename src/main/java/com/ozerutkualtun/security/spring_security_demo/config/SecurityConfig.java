package com.ozerutkualtun.security.spring_security_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
                .withUser(users.username("utku").password("test123").roles("ADMIN"))
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("susan").password("test123").roles("ADMIN"));
    }
}

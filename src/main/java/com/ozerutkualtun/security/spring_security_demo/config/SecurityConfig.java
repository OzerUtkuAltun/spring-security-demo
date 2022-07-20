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
                .withUser(users.username("utku").password("test123").roles("ADMIN"))
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("susan").password("test123").roles("ADMIN"));
    }

    // bu metod login formu customize etmek için kullanılacak
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated() // any request to the app must be authenticated(logged in)
                .and()
                .formLogin() // customizing login page.
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateUser")  // Login form should POST data to this URL for processing. Development not required. Spring security handle this :)
                .permitAll(); // Everyone can see the login form.
    }
}

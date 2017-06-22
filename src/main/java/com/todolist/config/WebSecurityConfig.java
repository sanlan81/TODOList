package com.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
//@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/admin*").access("hasRole('USER')")
                //.and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

        http.formLogin()
                .loginPage("/login.html")
                //.failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/").access("hasRole('USER')")
                .antMatchers("/create").access("hasRole('USER')")
                .antMatchers("/resources*").permitAll()
                .anyRequest().permitAll()
                .and();

        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true);
    }
}
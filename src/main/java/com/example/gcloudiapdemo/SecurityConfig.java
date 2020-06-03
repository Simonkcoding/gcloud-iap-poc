package com.example.gcloudiapdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/admin/**").authenticated()
                .and()
                .authorizeRequests().antMatchers("/api/**").authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
                .and()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint());
    }
}

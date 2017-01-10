package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/register").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/**").authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureForwardUrl("/login?error=true")
                    .loginProcessingUrl("/j_spring_security_check")
                    .defaultSuccessUrl("/users")
                    .permitAll()
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/logout")
                    .permitAll();

    }
}

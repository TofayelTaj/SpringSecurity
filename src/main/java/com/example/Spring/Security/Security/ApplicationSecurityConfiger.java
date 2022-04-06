package com.example.Spring.Security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.Spring.Security.Security.ApplicationUserRole.ADMIN;
import static com.example.Spring.Security.Security.ApplicationUserRole.STUDENT;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiger extends WebSecurityConfigurerAdapter {

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "login")
                .permitAll()
                .antMatchers("/api/**")
                .hasRole(STUDENT.name())
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic();
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .withUser("taj")
                .password(passwordEncoder.encode("password"))
                .roles("STUDENT")
                .and()
                .withUser("tofayel")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name());


    }
}

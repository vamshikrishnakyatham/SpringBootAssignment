package com.example.springboot.assignment.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)     //creates database connection
                .usersByUsernameQuery("select username,password,'true' from users  where username=?")
                .authoritiesByUsernameQuery("select username,role from users where username=?")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        String admin ="ROLE_ADMIN";

        http.authorizeRequests()

                .antMatchers("/todolist/showMyLoginPage").permitAll()
                .antMatchers("/todolist/showFormForUpdate").hasAuthority(admin)
                .antMatchers("/todolist/showFormForAdd").hasAuthority(admin)
                .antMatchers("/todolist/delete").hasAuthority(admin)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/todolist/list", true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");


    }
}
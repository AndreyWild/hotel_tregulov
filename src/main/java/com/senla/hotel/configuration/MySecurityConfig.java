package com.senla.hotel.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);

//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication().
//                withUser(userBuilder
//                        .username("wild")
//                        .password("wild")
//                        .roles("ADMINISTRATOR")).
//                withUser(userBuilder
//                        .username("guest")
//                        .password("guest")
//                        .roles("GUEST"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // доступ к url имеет несколько пользователей
                .antMatchers("/").hasAnyRole("ADMINISTRATOR", "GUEST")
                .antMatchers("/rooms/**").hasRole("GUEST")
                // доступ к url начинающийся с...  имеет один пользователь
                .antMatchers("/**").hasRole("ADMINISTRATOR")
                // форма логина и пароля будет запрашиваться у всех
                .and().formLogin().permitAll();
    }
}

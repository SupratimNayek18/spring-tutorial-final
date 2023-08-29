package com.spring.springsecurity2.config;

import com.spring.springsecurity2.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/home").hasRole("USER")
//                .antMatchers("/users/api/**").hasRole("ADMIN")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();

        //We need to either configure or disable csrf token to use post endpoints
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/home").hasRole("USER")
                .antMatchers("/users/api/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Also can use multiple roles to a user and explore preauthorize annotation
//        auth.inMemoryAuthentication().withUser("Shreyas").password(passwordEncoder().encode("1234")).roles("USER");
//        auth.inMemoryAuthentication().withUser("Supratim").password(passwordEncoder().encode("1234")).roles("ADMIN");


        //JPA Authentication using custom UserDetailsService and UserDetails
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());


        //Configuration for jdbc authentication
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select user_name,password,enabled from user where user_name=?")
//                .authoritiesByUsernameQuery("select user_name,role from user where user_name=?")
//                .passwordEncoder(passwordEncoder());

    }

    //Also refer nooppassword encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}

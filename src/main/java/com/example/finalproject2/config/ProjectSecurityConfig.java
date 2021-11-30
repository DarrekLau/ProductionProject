package com.example.finalproject2.config;

import com.example.finalproject2.component.SuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SuccessHandler successHandler;
    @Override
    public void configure(WebSecurity web) {

        //do not authenticate these APIs
        web.ignoring()
                .antMatchers("/index.html")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/resources/**")
                .antMatchers("/about.html")
                .antMatchers("/product-1.html")
                .antMatchers("/product-2.html")
                .antMatchers("/product-3.html")
                .antMatchers("/product-all.html");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/booking").permitAll()
                .antMatchers("/admin").authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/admin", true)
                .and()
                .httpBasic();

    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }
}

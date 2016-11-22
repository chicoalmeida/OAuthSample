package io.chico.controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

    @RequestMapping("/")
    public String loadHome() {
        return "home";
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                  .antMatchers("/", "/login**")
                  .permitAll()
                .anyRequest()
                  .authenticated();

    }
}

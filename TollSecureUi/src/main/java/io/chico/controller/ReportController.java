package io.chico.controller;

import io.chico.model.TollUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContext oAuth2ClientContext;
    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    public static final String SERVICE_TOLLDATA = "http://localhost:9001/services/tolldata";

    @RequestMapping("/")
    public String loadHome() {
        return "home";
    }


    @RequestMapping("/reports")
    public String loadReports(Model model) {
        OAuth2AccessToken token = oAuth2ClientContext.getAccessToken();
        System.out.println("Token: " + token.getValue());

        ResponseEntity<ArrayList<TollUsage>> tolls = oAuth2RestTemplate.exchange(
                SERVICE_TOLLDATA,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<TollUsage>>(){}
        );

        model.addAttribute("tolls", tolls.getBody());
        return "reports";
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

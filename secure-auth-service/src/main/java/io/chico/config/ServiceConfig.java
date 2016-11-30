package io.chico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * @author Francisco Almeida
 */
@Configuration
public class ServiceConfig extends GlobalAuthenticationConfigurerAdapter {

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("pablo").password("elpatron").roles("USER").and()
                .withUser("chico").password("pass").roles("USER", "OPERATOR");
    }
}

package com.springboot.application.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        /* 
         * Accepter toutes les requêtes http
         * @GaiusYan
         */
        http.authorizeHttpRequests((auth) -> 
            auth.requestMatchers("/demo/public").permitAll() // Accepter cette requête sans authentification
                .anyRequest() //Proteger toutes les autres authentifications
                .authenticated()).httpBasic();
        return http.build();
    }
}

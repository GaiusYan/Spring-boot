package com.springboot.application.Security.Config;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
            auth
                .requestMatchers("/demo/public").permitAll()  // Accepter cette requête après authentification
                .requestMatchers("/demo/admin").hasAnyRole("ROLE_ADMIN") //on recupère le role d'administration afin de lui donner la possibilité d'utiliser cette API
                .requestMatchers("/demo/user").hasRole("ROLE_USER")
                .requestMatchers("/demo/protected").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
                .anyRequest() //Proteger toutes les autres authentifications
                .authenticated()).httpBasic();
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = org.springframework.security.core.userdetails.User.builder()
        .username("user")
        .password("user")
        .roles("ROLE_USER")
        .build();

        UserDetails admin = org.springframework.security.core.userdetails.User.builder()
        .username("admin")
        .password("admin")
        .roles("ROLE_ADMIN")
        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

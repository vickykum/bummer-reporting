package com.bummer.bummer_reporting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/reviews/**").permitAll() // Allow access to /api/reviews endpoints
                                .anyRequest().authenticated() // All other endpoints require authentication
                )
                .csrf(csrf -> csrf.disable()); // Disable CSRF protection

        return http.build();
    }
}

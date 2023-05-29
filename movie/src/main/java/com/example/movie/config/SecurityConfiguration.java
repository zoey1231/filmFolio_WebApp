package com.example.movie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private CorsConfigurationSource corsConfigurationSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityConfiguration is being registered with Spring.");
        http.cors(withDefaults())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/users/login", "/api/users/register", "/api/users/test","/api/movies/search").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        http.oauth2ResourceServer()
                .jwt();
        System.out.println(http.cors().toString());
        return http.build();
    }

}


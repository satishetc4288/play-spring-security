package com.play.spring.springsecurity.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain basicAuthFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
            .httpBasic(Customizer.withDefaults())
            .sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            //.securityMatcher("/**")
            .authorizeHttpRequests( configure -> configure
                .requestMatchers("/actuator/*", "GET").permitAll()
                .requestMatchers("/auth/login", "POST").permitAll()
                .anyRequest().authenticated()
            )
            .build();
    }
}

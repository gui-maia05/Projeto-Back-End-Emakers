package com.br.emakers.apiEmakers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa CSRF para facilitar testes
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Libera todos os endpoints
                )
                .httpBasic(basic -> basic.disable()) // Desativa autenticação básica
                .formLogin(form -> form.disable()); // Desativa formulário de login

        return http.build();
    }
}

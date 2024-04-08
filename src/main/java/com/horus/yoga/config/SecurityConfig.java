package com.horus.yoga.config;

import com.horus.yoga.service.RandomAuthorizationFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {
    private final RandomAuthorizationFilter randomAuthorizationFilter;

    public SecurityConfig(RandomAuthorizationFilter randomAuthorizationFilter) {
        this.randomAuthorizationFilter = randomAuthorizationFilter;
    }

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/api/v2/**").authenticated()
                        .requestMatchers("/api/v1/**","/swagger-ui/**").permitAll())
                .formLogin(form -> form
                        .loginProcessingUrl("/api/v1/users/login/")
                        .successForwardUrl("/api/v2/users/")
                        .disable()
                )
                .addFilterBefore(randomAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}

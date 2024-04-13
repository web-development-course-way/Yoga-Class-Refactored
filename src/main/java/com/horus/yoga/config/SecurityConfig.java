package com.horus.yoga.config;

import com.horus.yoga.filter.CsrfCookieFilter;
import com.horus.yoga.filter.JWTTokenGeneratorFilter;
import com.horus.yoga.filter.JWTTokenValidatorFilter;
import com.horus.yoga.util.JWTTokenUtil;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import java.util.Collections;


@Configuration
public class SecurityConfig {

    private final JWTTokenGeneratorFilter jwtTokenGeneratorFilter;
    private final JWTTokenValidatorFilter jwtTokenValidatorFilter;

    public SecurityConfig(JWTTokenGeneratorFilter jwtTokenGeneratorFilter, JWTTokenValidatorFilter jwtTokenValidatorFilter) {
        this.jwtTokenGeneratorFilter = jwtTokenGeneratorFilter;
        this.jwtTokenValidatorFilter = jwtTokenValidatorFilter;
    }


    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("*"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setMaxAge(3600L);
                    return config;
                })).authorizeHttpRequests((requests) -> requests.requestMatchers("/**").permitAll() //TODO: this should be removed
                        .requestMatchers("/api/v2/**").authenticated().requestMatchers("/api/v1/users/**", "/swagger-ui/**", "/api/v1/**").permitAll()
                        .requestMatchers("/api/v2/class/**").hasRole("ADMIN"))
//                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class) //TODO: this was causing errors
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/api/v1/users/**", "/api/v1/register/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

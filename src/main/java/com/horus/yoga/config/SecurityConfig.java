package com.horus.yoga.config;

import com.horus.yoga.filter.CsrfCookieFilter;
import com.horus.yoga.filter.JWTTokenGeneratorFilter;
import com.horus.yoga.filter.JWTTokenValidatorFilter;
import com.horus.yoga.util.JWTTokenUtil;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

//    private final JWTTokenGeneratorFilter jwtTokenGeneratorFilter;
//    private final JWTTokenValidatorFilter jwtTokenValidatorFilter;
//
    public SecurityConfig(
//            JWTTokenGeneratorFilter jwtTokenGeneratorFilter,
//            JWTTokenValidatorFilter jwtTokenValidatorFilter,
            JwtAuthConverter jwtAuthConverter
    ) {
//        this.jwtTokenGeneratorFilter = jwtTokenGeneratorFilter;
//        this.jwtTokenValidatorFilter = jwtTokenValidatorFilter;
        this.jwtAuthConverter = jwtAuthConverter;
    }


    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .cors(corsCustomizer -> corsCustomizer.configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(Collections.singletonList("*"));
//                    config.setAllowedMethods(Collections.singletonList("*"));
//                    config.setAllowCredentials(true);
//                    config.setMaxAge(3600L);
//                    return config;
//                }))
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter)))
                .authorizeHttpRequests((requests) -> requests
                                .anyRequest().authenticated()
//                        .requestMatchers("/**").permitAll() //TODO: this should be removed
//                                .requestMatchers("/api/v2/**").authenticated()
//                                .requestMatchers("/api/v1/**").permitAll()

//                        .requestMatchers("/api/v1/users/**", "/swagger-ui/**", "/api/v1/**").permitAll()
//                        .requestMatchers("/api/v2/class/**").hasRole("ADMIN")
                );
//                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class) //TODO: this was causing errors
//                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
//                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).csrf((csrf) -> csrf.csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/api/v1/users/**", "/api/v1/register/**").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));


        return http.build();
    }


    @Bean
    public DefaultMethodSecurityExpressionHandler msecurity() {
        DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        defaultMethodSecurityExpressionHandler.setDefaultRolePrefix("");
        return defaultMethodSecurityExpressionHandler;
    }

    @Bean
    public JwtAuthenticationConverter con() {
        JwtAuthenticationConverter c =new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter cv = new JwtGrantedAuthoritiesConverter();
        cv.setAuthorityPrefix(""); // Default "SCOPE_"
        cv.setAuthoritiesClaimName("roles"); // Default "scope" or "scp"
        c.setJwtGrantedAuthoritiesConverter(cv);
        return c;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package com.example.edgeservice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class EdgeserviceApplication {

    private static final Log logger = LogFactory.getLog(EdgeserviceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EdgeserviceApplication.class, args);
    }

    @Bean
    KeyResolver keyResolver() {
        return exchange -> Mono.just("ANONYMOUS");
    }

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchange -> exchange.matchers(EndpointRequest.toAnyEndpoint()).permitAll()
                        .anyExchange().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

}

@RestController
class FallbackController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(FallbackController.class);

    @GetMapping("/users-fallback")
    Flux<Void> getBooksFallback() {
//        LOGGER.info("redirecting to user-fallbackUrl {}", 5);

//		log.info("Fallback for book service");
        return Flux.empty();
    }

}
package com.horus.yoga.config;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

//@Configuration
//public class JwtConfig {

//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        SignatureAlgorithm RS256 = SignatureAlgorithm.RS256;
//        return NimbusJwtDecoder.withSecretKey(new SecretKeySpec(secretKey.getBytes(), "RS256")).build();
//    }
//}
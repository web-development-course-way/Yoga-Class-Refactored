package com.horus.yoga.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Service
public class JWTTokenUtil {

    private final Algorithm hmac512;
    private final JWTVerifier verifier;


    private static final long EXPIRATION_TIME = 30000000;
    private static final Logger log = LoggerFactory.getLogger(JWTTokenUtil.class);
    private final Duration jwtValidityDuration = Duration.ofHours(24);

    @Value("${jwt.secret}")
    private String secretKey;



    public JWTTokenUtil(@Value("${jwt.secret}") String secretKey) {
        this.secretKey = secretKey;
        this.hmac512 = Algorithm.HMAC512(secretKey);
        this.verifier = JWT.require(this.hmac512).build();
    }

    public String generateToken(String email) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        ObjectMapper mapper = new ObjectMapper();
//        String authoritiesString = "";
//        try {
////            authoritiesString = mapper.writeValueAsString(authorities);
//        } catch (Exception e) {
//            System.out.println("auth   controller  " + e + "\n\n\n\n");
//            e.printStackTrace();
//        }
        Instant now = Instant.now();


        String token = JWT.create()
                .withSubject(email)
                .withIssuer("FMS")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(jwtValidityDuration.toMillis()))
                .sign(this.hmac512);
        return token;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
                    .parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.warn("JWT Token Invalid: {}", ex.getMessage());
            return false;
        }
    }


    public String validateAndGetSubject(String token) {
        try {
            return verifier.verify(token).getSubject();
        } catch (JWTVerificationException ex) {
            log.warn("JWT Token Invalid: {}", ex.getMessage());
            return null;
        }
    }
}
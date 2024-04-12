package com.horus.yoga.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;

@Service
public class JWTTokenUtil {

    private static final long EXPIRATION_TIME = 30000000;
    private static final Logger log = LoggerFactory.getLogger(JWTTokenUtil.class);

    @Value("${jwt.secret-key}")
    private final String secretKey;

    public JWTTokenUtil(String secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(Authentication authentication) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        ObjectMapper mapper = new ObjectMapper();
        String authoritiesString = "";
        try {
            authoritiesString = mapper.writeValueAsString(authorities);
        } catch (Exception e) {
            // handle potential exception during JSON serialization
            e.printStackTrace();
        }
        Instant now = Instant.now();
        return Jwts.builder()
                .setIssuer("Yoga-App")
                .setSubject("JWT Token")
                .claim("username", authentication.getName())
                .claim("authorities", authoritiesString)
                .setExpiration(Date.from(now.plusMillis(EXPIRATION_TIME)))
                .signWith(SignatureAlgorithm.HS256, key)
                .setIssuedAt(new Date())
                .compact();
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
}
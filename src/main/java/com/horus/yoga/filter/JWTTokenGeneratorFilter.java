package com.horus.yoga.filter;

import com.horus.yoga.util.JWTTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

    private JWTTokenUtil jwtTokenUtil;

    public JWTTokenGeneratorFilter(JWTTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public JWTTokenGeneratorFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String jwt = jwtTokenUtil.generateToken(authentication);
            response.setHeader("Authorization", "Bearer " + jwt);
        }

        filterChain.doFilter(request, response);
    }
}


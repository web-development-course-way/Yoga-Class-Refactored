package com.horus.yoga.service;

import com.horus.yoga.config.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RandomAuthorizationFilter extends OncePerRequestFilter {
    String hardCodedAuthToken = "randomtoken";
    private final UserDetailsServiceImpl userDetailsService;

    public RandomAuthorizationFilter(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authenticationHeaderValue = request.getHeader("Authorization");
        if (authenticationHeaderValue != null && authenticationHeaderValue.startsWith("Bearer ")) {
            //TODO add the token logic here
        }
        filterChain.doFilter(request,response);
    }
}

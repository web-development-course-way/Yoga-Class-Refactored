package com.horus.yoga.filter;

import com.horus.yoga.util.JWTTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTTokenValidatorFilter extends OncePerRequestFilter {

    private JWTTokenUtil jwtTokenUtil;

    public JWTTokenValidatorFilter(JWTTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public JWTTokenValidatorFilter() {
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        System.out.println("token "+ token);

//        if (token != null && token.startsWith("Bearer ")) { // only works in authentication and not sign in
//            token = token.substring(7); // Remove "Bearer " prefix
//            if (jwtTokenUtil.validateToken(token)) {
//                // Token is valid, continue processing the request
//
//                return;
//            } else {
//                // Invalid token, handle error (e.g., send unauthorized response)
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
//                return;
//            }
//        }
        filterChain.doFilter(request, response);
    }
}

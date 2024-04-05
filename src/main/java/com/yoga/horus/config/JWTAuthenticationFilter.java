package com.yoga.horus.config;
import com.yoga.horus.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request , HttpServletResponse response){
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request , HttpServletResponse response, FilterChain chain , Authentication authResult){
        String username = ((User) authResult.getPrincipal()).getFirstName();
        String token = jwtUtil.generateToken(username);
        response.addHeader("Authorization", "Bearer "+ token );
    }


}

package com.horus.yoga.service;

import com.horus.yoga.entity.User;
import com.horus.yoga.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserAuthenticationService implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        User user = userRepository.findByEmail(username).get();

        if (passwordEncoder.matches(pwd, user.getPassword())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
            return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
        } else {
            throw new BadCredentialsException("Invalid password!");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}

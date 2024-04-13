package com.horus.yoga.service;

import com.horus.yoga.entity.Authority;
import com.horus.yoga.entity.User;
import com.horus.yoga.enums.ErrorCode;
import com.horus.yoga.exceptions.UnauthorizedException;
import com.horus.yoga.repository.UserRepository;
import com.horus.yoga.util.JWTTokenUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserAuthenticationService implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JWTTokenUtil jwtTokenUtil;

    public UserAuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService, JWTTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> foundUserByEmail = userRepository.findByEmail(username);
        User user = foundUserByEmail.orElseThrow();


        if (passwordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(username, password, getGrantedAuthorities(user.getAuthorities()));
        } else {
            throw new BadCredentialsException("Invalid password!");
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }


    public String login(String email, String password) {

        User user = userService.getUserByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException(ErrorCode.INVALID_CREDS);
        } else {
            String token = jwtTokenUtil.generateToken(user.getEmail());

            return token;
        }
    }
}

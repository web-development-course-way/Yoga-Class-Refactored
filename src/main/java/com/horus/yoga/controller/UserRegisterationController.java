package com.horus.yoga.controller;

import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.entity.User;
import com.horus.yoga.service.UserService;
import com.horus.yoga.util.APIResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
public class UserRegisterationController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserRegisterationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/")
    public APIResponse<UserDTO> create(@RequestBody User user) {
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        UserDTO newUser = userService.create(user);
        return APIResponse.ok(newUser);
    }
}

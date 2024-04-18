//package com.horus.yoga.controller;
//
//import com.horus.yoga.dto.LoginDTO;
//import com.horus.yoga.dto.UserDTO;
//import com.horus.yoga.dto.LoginResponseRecord;
//import com.horus.yoga.entity.User;
////import com.horus.yoga.service.UserAuthenticationService;
//import com.horus.yoga.service.UserService;
//import com.horus.yoga.util.APIResponse;
//import com.horus.yoga.util.JWTTokenUtil;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
////@RequestMapping("/api/v1/register")
//public class UserRegisterationController {
//
//    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;
//    private JWTTokenUtil jwtTokenUtil;
//
//    private UserAuthenticationService userAuthenticationService;
//
//    public UserRegisterationController(UserService userService, PasswordEncoder passwordEncoder, JWTTokenUtil jwtTokenUtil, UserAuthenticationService userAuthenticationService) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userAuthenticationService = userAuthenticationService;
//    }
//
//    @PostMapping("/")
//    public APIResponse<UserDTO> create(@RequestBody User user) {
//        String hashPwd = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hashPwd);
//        UserDTO newUser = userService.create(user);
//        return APIResponse.ok(newUser);
//    }
//
//    @PostMapping("/login")
//    public APIResponse<LoginResponseRecord> login(@RequestBody LoginDTO loginDto) {
//        String userEmail = loginDto.email();
//        String password = loginDto.password();
//
//        String token = userAuthenticationService.login(userEmail, password);
//        return APIResponse.ok(new LoginResponseRecord(userEmail, token));
//    }
//}

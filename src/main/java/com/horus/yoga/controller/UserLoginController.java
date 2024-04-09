package com.horus.yoga.controller;


import com.horus.yoga.dto.LoginDTO;
import com.horus.yoga.service.UserAuthenticationService;
import com.horus.yoga.util.APIResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/v1/login")
//public class UserLoginController {
//
//    private final UserAuthenticationService userAuthenticationService;
//
//    public UserLoginController(UserAuthenticationService userAuthenticationService) {
//        this.userAuthenticationService = userAuthenticationService;
//    }
//
//    @PostMapping("/login")
//    public APIResponse<String> login(@RequestBody LoginDTO loginDTO){
//        String
//        return APIResponse.ok();
//    }
//
//}

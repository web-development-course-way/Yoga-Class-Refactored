package com.yoga.horus.controller;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.dtoMapper.UserMapper;
import com.yoga.horus.entity.User;
import com.yoga.horus.service.UserService;
import com.yoga.horus.util.APIResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public APIResponse<UserDTO> getById(@PathVariable UUID id) {
        UserDTO user= userService.getOne(id);
        return APIResponse.ok(user);
    }


    public APIResponse<UserDTO> getAll() {
        return null;
    }


    @PostMapping("/")
    public APIResponse<UserDTO> create(@RequestBody HttpServletRequest request) {
        return null;
    }


    public APIResponse<UserDTO> update(UUID id, HttpServletRequest request) {
        return null;
    }


    public APIResponse<UserDTO> delete(UUID id) {
        return null;
    }
}

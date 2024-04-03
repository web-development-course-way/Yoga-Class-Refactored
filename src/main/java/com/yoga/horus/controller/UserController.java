package com.yoga.horus.controller;

import com.yoga.horus.constant.Constant;
import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.entity.User;
import com.yoga.horus.service.UserService;
import com.yoga.horus.util.APIResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
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

    @GetMapping("/")
    public APIResponse<List<UserDTO>> getAll() {
        List<UserDTO> users = userService.getAll();
        return APIResponse.ok(users);
    }


    @PostMapping("/")
    public APIResponse<UserDTO> create(@RequestBody User user) {
        UserDTO newUser = userService.create(user);
        return APIResponse.ok(newUser);
    }


    @PutMapping("/{id}")
    public APIResponse<UserDTO> update(@PathVariable UUID id, @RequestBody User user) {
        UserDTO updatedUser = userService.update(id, user);
        return APIResponse.ok(updatedUser);
    }


    @DeleteMapping("/{id}")
    public APIResponse<String> delete(@PathVariable UUID id) {
        userService.delete(id);
        return APIResponse.ok(Constant.Deleted());
    }
}

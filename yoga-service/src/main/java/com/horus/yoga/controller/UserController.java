package com.horus.yoga.controller;

import com.horus.yoga.constant.Constant;
import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.entity.User;
import com.horus.yoga.service.UserService;
import com.horus.yoga.util.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController implements BaseController<User, UserDTO> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        LOGGER.info("instantiating the controller {}", 0);

        this.userService = userService;
    }

    @GetMapping("/{id}")
    public APIResponse<UserDTO> getById(@PathVariable UUID id) {
        UserDTO user = userService.getOne(id).get();
        return APIResponse.ok(user);
    }

    @GetMapping
    public APIResponse<List<UserDTO>> getAll() {
        LOGGER.info("getting all users {}", 0);

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
        String deletedObject = Constant.Deleted(userService.getOne(id).getClass());
        userService.delete(id);
        return APIResponse.ok(Constant.Deleted(deletedObject));
    }
}

package com.horus.yoga.service;

import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.dto.UserLoginDTO;
import com.horus.yoga.dtoMapper.UserMapper;
import com.horus.yoga.entity.User;
import com.horus.yoga.repository.UserRepository;
import com.horus.yoga.util.UserUpdate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService <User, UserDTO>{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private User user;

    public UserService(UserRepository userRepository, UserMapper userMapper,AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getOne(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDTO)
                .get();
    }

    public String authenticateUser(UserLoginDTO userLoginDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.email()
                        ,userLoginDTO.password())
        );
        String dummyToken = "randomtoken" + userLoginDTO.email();
        return dummyToken;
    }

    @Override
    public UserDTO create(User user) {
        User newUser = userRepository.save(user);
        return userMapper.userToUserDTO(newUser);
    }

    @Override
    public UserDTO update(UUID id, User user) {
       if (userRepository.existsById(id)){
           User existingUser = userRepository.findById(id).get();
           User updatedUser = UserUpdate.update(user,existingUser);
           User savedUser = userRepository.save(updatedUser);
           return userMapper.userToUserDTO(savedUser);
       } else {
           throw new NoSuchElementException();
       }
    }

    @Override
    public void delete(UUID id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }

    }


}

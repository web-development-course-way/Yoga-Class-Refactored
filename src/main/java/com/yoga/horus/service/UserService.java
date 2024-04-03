package com.yoga.horus.service;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.dtoMapper.UserMapper;
import com.yoga.horus.entity.User;
import com.yoga.horus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements BaseService <User,UserDTO>{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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



    @Override
    public UserDTO create(User user) {
        User newUser = userRepository.save(user);
        return userMapper.userToUserDTO(newUser);
    }

    @Override
    public UserDTO update(UUID id, User user) {
       if (userRepository.existsById(id)){
           User savedUser = userRepository.save(user);
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

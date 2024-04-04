package com.horus.yoga.service;

import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.dtoMapper.UserMapper;
import com.horus.yoga.entity.User;
import com.horus.yoga.repository.UserRepository;
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
    private User user;

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
           User existingUser = userRepository.findById(id).get();

           existingUser.setRole(user.getRole()
                   != null ? user.getRole() : existingUser.getRole());
           existingUser.setFirstName(user.getFirstName()
                   != null ? user.getFirstName() : existingUser.getFirstName());
           existingUser.setEmail(user.getEmail()
                   != null ? user.getEmail() : existingUser.getEmail());
           existingUser.setNationality(user.getNationality()
                   != null ? user.getNationality() : existingUser.getNationality());
           existingUser.setPhone(user.getPhone()
                   != null ? user.getPhone() : existingUser.getPhone());
           existingUser.setLastName(user.getLastName()
                   != null ? user.getLastName() : existingUser.getLastName());
           existingUser.setDateOfBirth(user.getDateOfBirth()
                   != null ? user.getDateOfBirth() : existingUser.getDateOfBirth());

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

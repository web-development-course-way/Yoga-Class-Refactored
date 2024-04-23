package com.yoga.horus.service;


import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.dtoMapper.UserMapper;
import com.horus.yoga.dtoMapper.UserMapperImpl;
import com.horus.yoga.entity.User;
import com.horus.yoga.repository.UserRepository;
import com.horus.yoga.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Date;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Spy
    private UserMapper userMapper = new UserMapperImpl();


    @Test
    @DisplayName("Creation for the user object")
    public void createUserTest(){
        User user = new User().setEmail("deebo@gmail.com")
                              .setFirstName("Deeb")
                              .setLastName("Deboo")
                              .setPhone("018822447")
                              .setDateOfBirth(new Date());

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        UserDTO savedDTO = userService.create(user);

        Assertions.assertNotNull(savedDTO);

    }



}

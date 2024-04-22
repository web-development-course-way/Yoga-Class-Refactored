package com.yoga.horus.service;

import com.horus.yoga.HorusApplication;
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
import org.mapstruct.DecoratedWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Spy
    private UserMapper userMapper = new UserMapperImpl();


    //test create method
    //create user class using builder.
    //mock user repo.save -->return DTO
    //userservice .create -->user DTO
    //assert ==

    @Test
    @DisplayName("Creation for the user object")
    public void createUserTest(){
        User user = new User().setEmail("deebo@gmail.com")
                              .setFirstName("Deeb")
                              .setLastName("Deboo")
                              .setPhone("018822447")
                              .setDateOfBirth(new Date());

        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User savedUser = userService.createWithoutDTO(user);
        UserDTO savedDTO = userService.create(user);

        Assertions.assertNotNull(savedDTO);

    }



}

package com.yoga.horus.service;


import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.dtoMapper.UserMapper;
import com.horus.yoga.dtoMapper.UserMapperImpl;
import com.horus.yoga.entity.User;
import com.horus.yoga.repository.UserRepository;
import com.horus.yoga.service.UserService;
import org.junit.jupiter.api.*;
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

    private static User user1, user2;

    @BeforeAll
    public static void createTestUsers() {
        user1 = new User().setEmail("MrDeeb@gmail.com")
                .setFirstName("Ahmad")
                .setLastName("Al-Deeb")
                .setPhone("0121121212")
                .setDateOfBirth(new Date());

        user2 = new User().setEmail("andrew@gmail.com")
                .setFirstName("Andrew")
                .setLastName("Seif")
                .setPhone("01313131313")
                .setDateOfBirth(new Date());

    }

    @Test
    @DisplayName("Create user")
    public void createUserTest(){
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user1);

        UserDTO savedDTO = userService.create(user1);

        Assertions.assertNotNull(savedDTO);

    }



}

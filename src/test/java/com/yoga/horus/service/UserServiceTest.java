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


import java.util.*;

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
        user1 = new User().setId(UUID.randomUUID())
                .setEmail("MrDeeb@gmail.com")
                .setFirstName("Ahmad")
                .setLastName("Al-Deeb")
                .setPhone("0121121212")
                .setDateOfBirth(new Date());

        user2 = new User().setId(UUID.randomUUID())
                .setEmail("andrew@gmail.com")
                .setFirstName("Andrew")
                .setLastName("Seif")
                .setPhone("01313131313")
                .setDateOfBirth(new Date());

    }

    @Test
    @DisplayName("Create user")
    public void createUserTest(){
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user1);

        UserDTO savedUser = userService.create(user1);

        Assertions.assertNotNull(savedUser, "The saved user should not be null");

    }

    @Test
    @DisplayName("Get all users")
    public void getAllUsersTest() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<UserDTO> foundUsers = userService.getAll();

        Assertions.assertEquals(2, foundUsers.size(), "userService.getAll() should return 2 users");
    }

    @Test
    @DisplayName("Get existing user")
    public void getExistingUser() {
        when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

        Optional<UserDTO> foundUser = Optional.ofNullable(userService.getOne(user1.getId()));

        Assertions.assertTrue(foundUser.isPresent(), "User was not found");
        Assertions.assertEquals(userMapper.userToUserDTO(user1), foundUser.get(), "Users must be the same");
    }

//    @Test
//    @DisplayName("Get not existing user")
//    public void getNotExistingUser() {
//        UUID randomId = UUID.randomUUID();
//
//        when(userRepository.findById(randomId)).thenReturn(Optional.empty());
//
//        Optional<UserDTO> foundUser = Optional.ofNullable(userService.getOne(randomId));
//
//        Assertions.assertFalse(foundUser.isPresent(), "User was not found");
//    }

}

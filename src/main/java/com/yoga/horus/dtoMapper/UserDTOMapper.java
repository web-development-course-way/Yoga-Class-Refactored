package com.yoga.horus.dtoMapper;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function <User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getEmail(),
                user.getRole()
        );
    }
}

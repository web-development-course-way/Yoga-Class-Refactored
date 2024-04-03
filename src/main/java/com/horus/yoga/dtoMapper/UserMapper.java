package com.horus.yoga.dtoMapper;

import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.entity.User;
import org.mapstruct.Mapper;



@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}

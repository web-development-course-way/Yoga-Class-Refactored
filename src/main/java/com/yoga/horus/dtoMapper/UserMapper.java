package com.yoga.horus.dtoMapper;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.entity.User;
import org.mapstruct.Mapper;



@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}

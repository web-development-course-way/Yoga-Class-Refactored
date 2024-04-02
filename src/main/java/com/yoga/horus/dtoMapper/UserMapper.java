package com.yoga.horus.dtoMapper;

import com.yoga.horus.dto.UserDTO;
import com.yoga.horus.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}

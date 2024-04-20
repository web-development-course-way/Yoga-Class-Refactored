package com.horus.yoga.dtoMapper;

import com.horus.yoga.dto.UserDTO;
import com.horus.yoga.dto.UserKeycloakDTO;
import com.horus.yoga.entity.User;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserKeycloakMapper {

    UserRepresentation UserKeycloakToUserRep (UserKeycloakDTO userKeycloakDTO);
    UserKeycloakDTO UserRepToUserKeycloak (UserRepresentation userRepresentation);

}

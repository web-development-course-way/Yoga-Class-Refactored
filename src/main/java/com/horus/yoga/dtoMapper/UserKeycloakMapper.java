package com.horus.yoga.dtoMapper;

import com.horus.yoga.dto.UserKeycloakDTO;

import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserKeycloakMapper {

    UserKeycloakDTO UserRepToUserKeycloak (UserRepresentation userRepresentation);

}

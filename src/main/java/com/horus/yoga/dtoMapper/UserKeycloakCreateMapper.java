package com.horus.yoga.dtoMapper;


import com.horus.yoga.dto.UserKeycloakCreateDTO;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserKeycloakCreateMapper {

    UserRepresentation userKeycloakCreateToUserRep (UserKeycloakCreateDTO userKeycloakCreateDTO);
}

package com.horus.yoga.keycloakclient;


import com.horus.yoga.dto.UserKeycloakCreateDTO;
import com.horus.yoga.dto.UserKeycloakDTO;
import com.horus.yoga.dtoMapper.UserKeycloakCreateMapper;
import com.horus.yoga.dtoMapper.UserKeycloakMapper;
import com.horus.yoga.util.KeycloakSecurityUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keycloak/users")
@SecurityRequirement(name = "Keycloak")
public class UserResource {

    private final KeycloakSecurityUtil keycloakSecurityUtil;
    private final UserKeycloakMapper userKeycloakMapper;
    private final UserKeycloakCreateMapper userKeycloakCreateMapper;

    @Value("${keycloak.realm}")
    private String realm;

    public UserResource(KeycloakSecurityUtil keycloakSecurityUtil, UserKeycloakMapper userKeycloakMapper, UserKeycloakCreateMapper userKeycloakCreateMapper) {
        this.keycloakSecurityUtil = keycloakSecurityUtil;
        this.userKeycloakMapper = userKeycloakMapper;
        this.userKeycloakCreateMapper = userKeycloakCreateMapper;
    }

    @GetMapping
    @RequestMapping("/")
    public List<UserKeycloakDTO> getAll() {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        List<UserRepresentation> userRepresentations =
                keycloak.realm(realm).users().list();
        return userRepresentations.stream()
                .map(userKeycloakMapper::UserRepToUserKeycloak)
                .toList();
    }

    @GetMapping(value = "/{id}")
    public UserKeycloakDTO getOne(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        UserRepresentation user = keycloak.realm(realm).users().get(id).toRepresentation();
        return userKeycloakMapper.UserRepToUserKeycloak(user);
    }

    @PostMapping(value = "/")
    public Response createUser(@RequestBody UserKeycloakCreateDTO userKeycloakCreateDTO) {
        UserRepresentation userRep = userKeycloakCreateMapper.userKeycloakCreateToUserRep(userKeycloakCreateDTO);
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        Response res = keycloak.realm(realm).users().create(userRep);
        return Response.ok().build();
    }

    @PutMapping(value = "/{id}")
    public Response updateUser(@RequestBody UserKeycloakCreateDTO userKeycloakCreateDTO,
                               @PathVariable("id") String id) {
        UserRepresentation userRep = userKeycloakCreateMapper.userKeycloakCreateToUserRep(userKeycloakCreateDTO);
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        keycloak.realm(realm).users().get(id).update(userRep);
        return Response.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public Response deleteUser(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        keycloak.realm(realm).users().delete(id);
        return Response.ok().build();
    }
}

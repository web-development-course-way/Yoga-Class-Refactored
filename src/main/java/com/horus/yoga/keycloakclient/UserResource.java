package com.horus.yoga.keycloakclient;


import com.horus.yoga.dto.UserKeycloakDTO;
import com.horus.yoga.dtoMapper.UserKeycloakMapper;
import com.horus.yoga.util.KeycloakSecurityUtil;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/keycloak")
@SecurityRequirement(name = "Keycloak")
public class UserResource {

    private final KeycloakSecurityUtil keycloakSecurityUtil;
    private final UserKeycloakMapper userKeycloakMapper;

    @Value("${keycloak.realm}")
    private String realm;

    public UserResource(KeycloakSecurityUtil keycloakSecurityUtil, UserKeycloakMapper userKeycloakMapper) {
        this.keycloakSecurityUtil = keycloakSecurityUtil;
        this.userKeycloakMapper = userKeycloakMapper;
    }

    @GetMapping
    @RequestMapping("/users")
    public List<UserKeycloakDTO> getAll() {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        System.out.println(realm);
        List<UserRepresentation> userRepresentations =
                keycloak.realm(realm).users().list();
        return userRepresentations.stream()
                .map(userKeycloakMapper::UserRepToUserKeycloak)
                .toList();
    }

    @GetMapping(value = "/users/{id}")
    public UserKeycloakDTO getOne(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        UserRepresentation user = keycloak.realm(realm).users().get(id).toRepresentation();
        return userKeycloakMapper.UserRepToUserKeycloak(user);
    }

    @PostMapping(value = "/user")
    public Response createUser(UserKeycloakDTO userKeycloakDTO) {
        UserRepresentation userRep = userKeycloakMapper.UserKeycloakToUserRep(userKeycloakDTO);
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        Response res = keycloak.realm(realm).users().create(userRep);
        return Response.ok(userKeycloakDTO).build();
    }

    @PutMapping(value = "/user")
    public Response updateUser(UserKeycloakDTO userKeycloakDTO) {
        UserRepresentation userRep = userKeycloakMapper.UserKeycloakToUserRep(userKeycloakDTO);
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        keycloak.realm(realm).users().get(userKeycloakDTO.id()).update(userRep);
        return Response.ok(userKeycloakDTO).build();
    }

    @DeleteMapping(value = "/users/{id}")
    public Response deleteUser(@PathVariable("id") String id) {
        Keycloak keycloak = keycloakSecurityUtil.getKeycloakInstance();
        keycloak.realm(realm).users().delete(id);
        return Response.ok().build();
    }

}

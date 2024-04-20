package com.horus.yoga.dto;

public record UserKeycloakDTO(String id,
                              String firstName,
                              String lastName,
                              String email,
                              String userName,
                              String password) {
}

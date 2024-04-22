package com.horus.yoga.dto;

public record UserKeycloakCreateDTO(String firstName,
                                    String lastName,
                                    String email,
                                    String userName,
                                    String password) {
}

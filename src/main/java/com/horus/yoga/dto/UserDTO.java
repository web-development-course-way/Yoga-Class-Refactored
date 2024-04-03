package com.horus.yoga.dto;

import com.horus.yoga.enums.Role;

import java.util.UUID;


public record UserDTO(UUID id,
                      String firstName,
                      String email,
                      Role role) {
}

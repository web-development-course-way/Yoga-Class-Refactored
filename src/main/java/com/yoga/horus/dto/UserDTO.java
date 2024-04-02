package com.yoga.horus.dto;

import com.yoga.horus.enums.Role;

import java.util.UUID;


public record UserDTO(UUID id,
                      String firstName,
                      String email,
                      Role role) {
}

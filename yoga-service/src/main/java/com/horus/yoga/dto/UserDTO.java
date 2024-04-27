package com.horus.yoga.dto;

import java.util.UUID;


public record UserDTO(UUID id,
                      String firstName,
                      String email) {
}

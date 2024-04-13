package com.horus.yoga.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public record LoginResponseRecord(
        String email,

        String token

) {

}

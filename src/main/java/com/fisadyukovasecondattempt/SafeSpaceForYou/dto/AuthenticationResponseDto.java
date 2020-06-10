package com.fisadyukovasecondattempt.SafeSpaceForYou.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponseDto {

    private String username;
    private String token;

}

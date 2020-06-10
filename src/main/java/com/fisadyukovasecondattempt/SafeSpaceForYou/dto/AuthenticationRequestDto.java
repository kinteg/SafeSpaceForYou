package com.fisadyukovasecondattempt.SafeSpaceForYou.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AuthenticationRequestDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

}

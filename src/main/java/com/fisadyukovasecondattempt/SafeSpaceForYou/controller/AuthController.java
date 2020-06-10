package com.fisadyukovasecondattempt.SafeSpaceForYou.controller;

import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationRequestDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationResponseDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.UserLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserLoginService userLoginService;

    public AuthController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@Valid @RequestBody AuthenticationRequestDto auth) {
        return ResponseEntity.ok(userLoginService.login(auth));
    }

}

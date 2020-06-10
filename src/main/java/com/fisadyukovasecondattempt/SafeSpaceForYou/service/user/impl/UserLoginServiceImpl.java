package com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.impl;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationRequestDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationResponseDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.repo.UserRepo;
import com.fisadyukovasecondattempt.SafeSpaceForYou.security.jwt.JwtTokenProvider;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.UserLoginService;
import org.aspectj.weaver.BCException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserLoginServiceImpl(
            @Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            UserRepo userRepo,
            BCryptPasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto auth) {

        String username = auth.getUsername();
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found."));

        authenticate(auth);
        user.setPassword(passwordEncoder.encode(auth.getPassword()));
        userRepo.save(user);

        return new AuthenticationResponseDto(username, createToken(user));
    }

    private void authenticate(AuthenticationRequestDto auth) {
        try {
            var user = new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());
            authenticationManager.authenticate(user);
        } catch (AuthenticationException ex) {
            throw new BCException("Invalid username or password.");
        }
    }

    private String createToken(User user) {
        return jwtTokenProvider.createToken(user.getUsername(), user.getRole());
    }

}

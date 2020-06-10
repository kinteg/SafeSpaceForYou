package com.fisadyukovasecondattempt.SafeSpaceForYou.security;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import com.fisadyukovasecondattempt.SafeSpaceForYou.security.jwt.JwtUserFactory;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        return JwtUserFactory.create(user);
    }
}

package com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.impl;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import com.fisadyukovasecondattempt.SafeSpaceForYou.repo.UserRepo;
import com.fisadyukovasecondattempt.SafeSpaceForYou.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(
            UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
    }

}

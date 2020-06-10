package com.fisadyukovasecondattempt.SafeSpaceForYou.service.user;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findByUsername(String username);

}

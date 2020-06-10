package com.fisadyukovasecondattempt.SafeSpaceForYou.service.user;

import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationRequestDto;
import com.fisadyukovasecondattempt.SafeSpaceForYou.dto.AuthenticationResponseDto;
import org.springframework.stereotype.Component;

@Component
public interface UserLoginService {

    AuthenticationResponseDto login(AuthenticationRequestDto auth);

}

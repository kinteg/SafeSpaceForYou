package com.fisadyukovasecondattempt.SafeSpaceForYou.security.jwt;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.RoleEntity;
import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class JwtUserFactory {

    public static JwtUser create(User user) {
        return JwtUser
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .authorities(mapToGrantedAuthority(user.getRole()))
                .lastPasswordResetDate(user.getUpdated())
                .enabled(true)
                .build();
    }

    private static List<GrantedAuthority> mapToGrantedAuthority(List<RoleEntity> userRoleEntities) {
        return userRoleEntities.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}

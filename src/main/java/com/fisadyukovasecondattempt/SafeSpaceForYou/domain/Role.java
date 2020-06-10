package com.fisadyukovasecondattempt.SafeSpaceForYou.domain;

import lombok.Getter;

public enum Role {

    ROLE_ADMIN("ADMIN"), ROLE_USER("USER");

    @Getter
    private String shortName;

    Role(String shortName) {
        this.shortName = shortName;
    }

}

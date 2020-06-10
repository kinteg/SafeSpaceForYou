package com.fisadyukovasecondattempt.SafeSpaceForYou.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usr")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 15)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @Column(name = "password")
    @NotNull
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<RoleEntity> role;

}

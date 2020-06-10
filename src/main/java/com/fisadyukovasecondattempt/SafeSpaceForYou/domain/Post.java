package com.fisadyukovasecondattempt.SafeSpaceForYou.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "post")
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Post extends BaseEntity {

    @NotNull
    @Size(min = 10)
    private String title;

    @NotNull
    @Size(min = 10)
    private String mainText;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}

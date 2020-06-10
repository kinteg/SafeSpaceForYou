package com.fisadyukovasecondattempt.SafeSpaceForYou.dto;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.Post;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreatePostDto {

    @NotNull
    @Size(min = 10)
    private String title;

    @NotNull
    @Size(min = 10)
    private String mainText;

    public Post toPost() {
        return Post
                .builder()
                .mainText(mainText)
                .title(title)
                .build();
    }

}

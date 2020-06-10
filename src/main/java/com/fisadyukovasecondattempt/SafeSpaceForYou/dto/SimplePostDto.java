package com.fisadyukovasecondattempt.SafeSpaceForYou.dto;

import com.fisadyukovasecondattempt.SafeSpaceForYou.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SimplePostDto {

    private Long id;
    private String title;
    private String mainText;
    private String username;
    private String firstName;
    private String lastName;

    public static SimplePostDto toSimplePost(Post post) {
        return SimplePostDto
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .mainText(post.getMainText())
                .username(post.getUser().getUsername())
                .firstName(post.getUser().getFirstName())
                .lastName(post.getUser().getLastName())
                .build();
    }

}

package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostDeleteDto {

    @NotBlank
    private Long postId;
    @NotBlank
    private String postTitle;
    @NotBlank
    private String postContent;
    @NotBlank
    private Boolean postDeleteYn;

    @Builder
    public PostDeleteDto(Long postId, String postTitle, String postContent,Boolean postDeleteYn ) {
        this.postId = postId;
        this.postTitle= postTitle;
        this.postContent = postContent;
        this.postDeleteYn = !postDeleteYn;
    }
}

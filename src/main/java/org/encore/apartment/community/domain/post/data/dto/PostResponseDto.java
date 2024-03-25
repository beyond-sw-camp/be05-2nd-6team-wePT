package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Post;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {
    // response는 모두 검증되서 들어옴 -> annotation 필요 없음

    private Long postId;

    private Long postCategoryId;

    private String postTitle;

    private String postWriterId;

    private String postContent;

    private LocalDateTime postDate;

    private Integer postRecommend;

    private Boolean postDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public PostResponseDto(Long postId,Long postCategoryId, String postWriterId, String postTitle, String postContent,
                          LocalDateTime postDate,Integer postRecommend, Boolean postDeleteYn, LocalDateTime updatedAt ) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.postWriterId = postWriterId;
        this.postTitle= postTitle;
        this.postContent = postContent;
        this.postDate =postDate;
        this.postRecommend = postRecommend;
        this.postDeleteYn = postDeleteYn;
        this.updatedAt = updatedAt;
    }

}

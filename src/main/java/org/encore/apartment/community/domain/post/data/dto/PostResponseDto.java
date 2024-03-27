package org.encore.apartment.community.domain.post.data.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostResponseDto {

    private Long postId;

    private Long postCategoryId;

    private String postTitle;

    private Long userIdx;

    private String postContent;

    private LocalDateTime postDate;

    private Integer postRecommend;

    private Boolean postDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public PostResponseDto(Long postId,Long postCategoryId, Long userIdx, String postTitle, String postContent,
                          LocalDateTime postDate,Integer postRecommend, Boolean postDeleteYn, LocalDateTime updatedAt ) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.userIdx = userIdx;
        this.postTitle= postTitle;
        this.postContent = postContent;
        this.postDate =postDate;
        this.postRecommend = postRecommend;
        this.postDeleteYn = postDeleteYn;
        this.updatedAt = updatedAt;
    }

}

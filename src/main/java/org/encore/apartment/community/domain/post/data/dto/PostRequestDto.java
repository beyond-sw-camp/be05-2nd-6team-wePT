package org.encore.apartment.community.domain.post.data.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Post;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostRequestDto {
    // data 검증 필요 -> @notnull? @noblanck? @notempty
    @NotBlank
    private Long postId;
    @NotBlank
    private Long postCategoryId;
    @NotBlank
    private String postTitle;
    @NotBlank
    private String postWriterId;
    @NotBlank
    private String postContent;
    @NotBlank
    private LocalDateTime postDate;
    @NotBlank
    private Integer postRecommend;
    @NotBlank
    private Boolean postDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public PostRequestDto(Long postId,Long postCategoryId, String postWriterId, String postTitle, String postContent,
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

    public Post ToEntity(){
        return Post.builder()
                .postWriterId(this.postWriterId)
                .postTitle(this.postTitle)
                .postContent(this.postContent)
                .postCategoryId(this.postCategoryId)
                .postDeleteYn(this.postDeleteYn)
                .updatedAt(this.updatedAt)
                .postRecommend(this.postRecommend)
                .postDate(this.postDate)
                .build();
    }
}

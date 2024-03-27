package org.encore.apartment.community.domain.post.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.user.data.entity.User;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PostRequestDto {

    @NotBlank
    private Long postId;
    @NotBlank
    private Long postCategoryId;
    @NotBlank
    private String postTitle;
    @NotBlank
    private String postContent;
    @NotBlank
    private LocalDateTime postDate;
    @NotBlank
    private Integer postRecommend;
    @NotBlank
    @Schema(description = "게시물 삭제 여부", example = "false")
    private Boolean postDeleteYn;

    private LocalDateTime updatedAt;
    @NotBlank
    private Long userIdx;

    @Builder
    public PostRequestDto(Long postId,Long postCategoryId, String postTitle, String postContent,
                          LocalDateTime postDate,Integer postRecommend, Boolean postDeleteYn, LocalDateTime updatedAt ,
                          Long userIdx) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.postTitle= postTitle;
        this.postContent = postContent;
        this.postDate =postDate;
        this.postRecommend = postRecommend;
        this.postDeleteYn = postDeleteYn;
        this.updatedAt = updatedAt;
        this.userIdx = userIdx;
    }

    public Post ToEntity(User user){
        return Post.builder()
                .postTitle(this.postTitle)
                .postContent(this.postContent)
                .postCategoryId(this.postCategoryId)
                .postDeleteYn(this.postDeleteYn)
                .updatedAt(this.updatedAt)
                .postRecommend(this.postRecommend)
                .postDate(this.postDate)
                .user(user)
                .build();
    }


}

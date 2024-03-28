package org.encore.apartment.community.domain.post.data.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;
import org.encore.apartment.community.domain.user.data.entity.User;


import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CommentRequestDto {

    @NotBlank
    private Long commentIdx;
    @NotBlank
    private Long commentId;
    @NotBlank
    private Long postId;
    @NotBlank
    private Long userIdx;
    @NotBlank
    private String commentContent;
    @NotBlank
    private LocalDateTime commentDate;
    @NotBlank
    @Schema(description = "댓글 삭제 여부", example = "false")
    private Boolean commentDeleteYn;
    @NotBlank
    private LocalDateTime updatedAt;

    @Builder
    public CommentRequestDto(Long commentIdx, Long commentId, Long postId, Long userIdx,
                             String commentContent, LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.commentId = commentId;
        this.postId = postId;
        this.commentContent = commentContent;
        this.userIdx = userIdx;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }

    public Comment ToEntity(Post post, User user){
        return Comment.builder()
                .commentIdx(this.commentIdx)
                .commentId(this.commentId)
                .post(post)
                .commentContent(this.commentContent)
                .user(user)
                .commentDate(this.commentDate)
                .commentDeleteYn(this.commentDeleteYn)
                .updatedAt(this.updatedAt)
                .build();
    }
}

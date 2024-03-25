package org.encore.apartment.community.domain.post.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class CommentRequestDto {

    @NotBlank
    private Long commentIdx;
    @NotBlank
    private Long commentId;
    @NotBlank
    private Long postId;
    @NotBlank
    private String commentWriterId;
    @NotBlank
    private String commentContent;
    @NotBlank
    private LocalDateTime commentDate;
    @NotBlank
    private Boolean commentDeleteYn;
    @NotBlank
    private LocalDateTime updatedAt;

    @Builder
    public CommentRequestDto(Long commentIdx, Long commentId, Long postId, String commentWriterId,
                             String commentContent, LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.commentId = commentId;
        this.postId = postId;
        this.commentContent = commentContent;
        this.commentWriterId = commentWriterId;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }

    public Comment ToEntity(){
        return Comment.builder()
                .commentIdx(this.commentIdx)
                .commentId(this.commentId)
                .postId(this.postId)
                .commentContent(this.commentContent)
                .commentWriterId(this.commentWriterId)
                .commentDate(this.commentDate)
                .commentDeleteYn(this.commentDeleteYn)
                .updatedAt(this.updatedAt)
                .build();
    }
}

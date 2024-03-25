package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {


    private Long commentIdx;

    private Long commentId;

    private Long postId;

    private String commentWriterId;

    private String commentContent;

    private LocalDateTime commentDate;

    private Boolean commentDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public CommentResponseDto(Long commentIdx, Long commentId, Long postId, String commentWriterId,
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
}

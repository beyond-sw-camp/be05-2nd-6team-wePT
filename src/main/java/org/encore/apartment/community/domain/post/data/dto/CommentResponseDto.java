package org.encore.apartment.community.domain.post.data.dto;


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

    private Long userIdx;

    private String commentContent;

    private LocalDateTime commentDate;

    private Boolean commentDeleteYn;

    private LocalDateTime updatedAt;

    @Builder
    public CommentResponseDto(Long commentIdx, Long commentId, Long postId, Long userIdx,
                             String commentContent, LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.commentId = commentId;
        this.postId = postId;
        this.userIdx = userIdx;
        this.commentDate = commentDate;
        this.commentContent = commentContent;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }
}

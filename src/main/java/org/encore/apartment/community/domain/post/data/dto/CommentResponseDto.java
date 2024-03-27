package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Post;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long commentIdx;

    private Long commentId;

//    private Post post;

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
//        if (post !=  null)
//            this.postId = post.getPostId();
//        else
//            this.postId = 0L;
        this.commentContent = commentContent;
        this.commentWriterId = commentWriterId;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }
}

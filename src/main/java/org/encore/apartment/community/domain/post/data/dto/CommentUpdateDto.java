package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Comment;
import org.encore.apartment.community.domain.post.data.entity.Post;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentUpdateDto {

    @NotBlank
    private Long commentIdx;
    @NotBlank
    private String commentWriterId;
    @NotBlank
    private String commentContent;
    @NotBlank
    private LocalDateTime updatedAt;




    @Builder
    public CommentUpdateDto(Long commentIdx, String commentWriterId, String commentContent, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.commentWriterId = commentWriterId;
        this.commentContent = commentContent;
        this.updatedAt = updatedAt;
    }
    public Comment ToEntity(){
        return Comment.builder()
                .commentIdx(this.commentIdx)
                .commentWriterId(this.commentWriterId)
                .commentContent(this.commentContent)
                .updatedAt(this.updatedAt)
                .build();
    }

}

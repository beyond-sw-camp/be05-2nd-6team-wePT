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


    private Long commentIdx;

    private String commentWriterId;

    private String commentContent;

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

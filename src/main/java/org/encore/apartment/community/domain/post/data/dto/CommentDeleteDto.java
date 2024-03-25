package org.encore.apartment.community.domain.post.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.post.data.entity.Comment;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
public class CommentDeleteDto {

    @NotBlank
    private Long commentIdx;
    @NotBlank
    private String commentWriterId;
    @NotBlank
    private Boolean commentDeleteYn;


    @Builder
    public CommentDeleteDto(Long commentIdx, String commentWriterId,
                             Boolean commentDeleteYn){
        this.commentIdx = commentIdx;
        this.commentWriterId = commentWriterId;
        this.commentDeleteYn = commentDeleteYn;

    }

    public Comment ToEntity(){
        return Comment.builder()
                .commentIdx(this.commentIdx)
                .commentWriterId(this.commentWriterId)
                .commentDeleteYn(this.commentDeleteYn)
                .build();
    }
}

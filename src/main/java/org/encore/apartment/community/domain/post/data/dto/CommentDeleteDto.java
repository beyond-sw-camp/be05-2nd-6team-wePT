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

    private Long commentIdx;

    private String commentWriterId;

    private Boolean commentDeleteYn;


    @Builder
    public CommentDeleteDto(Long commentIdx, String commentWriterId,
                             Boolean commentDeleteYn){
        this.commentIdx = commentIdx;
        this.commentWriterId = commentWriterId;
        this.commentDeleteYn = commentDeleteYn;

    }

}

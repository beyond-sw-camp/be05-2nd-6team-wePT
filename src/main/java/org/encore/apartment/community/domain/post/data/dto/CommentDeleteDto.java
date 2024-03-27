package org.encore.apartment.community.domain.post.data.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class CommentDeleteDto {

    private Long commentIdx;

    private Boolean commentDeleteYn;

    private LocalDateTime updatedAt;
    @Builder
    public CommentDeleteDto(Long commentIdx,  Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;

    }

}

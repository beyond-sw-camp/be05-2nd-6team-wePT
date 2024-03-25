package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // 객체 매핑
//@Table(name="comment")
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;

    @Column(name = "comment_id" ,nullable = false)
    private Long commentId;

    @Column(name = "post_id" ,nullable = false)
    private Long postId;

    @Column(name = "comment_writer_id" ,nullable = false)
    private String commentWriterId;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_date" ,nullable = false)
    private LocalDateTime commentDate;

    @Column(name = "comment_delete_yn" ,nullable = false)
    private Boolean commentDeleteYn;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long commentIdx, Long postId,Long commentId, String commentWriterId, String commentContent,
                   LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.postId = postId;
        this.commentId = commentId;
        this.commentWriterId = commentWriterId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }

    public void update(Long commentIdx,String commentWriterId,  String commentConetent, LocalDateTime updatedAt) {
        this.commentIdx = commentIdx;
        this.commentWriterId = commentWriterId;
        this.commentContent = commentConetent;
        this.updatedAt = updatedAt;
    }

    public void delete( Boolean commentDeleteYn ){
        this.commentDeleteYn = true;
    }




}

package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // 객체 매핑
@Table(name="comment")
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;

    @Column(name = "comment_id" ,nullable = false)
    private Long commentId;

//    @Column(name = "post_id" ,nullable = false)
//    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "comment_writer_id" ,nullable = false)
    private String commentWriterId;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_date" ,nullable = false)
    private LocalDateTime commentDate;

    @Column(name = "comment_delete_yn" ,nullable = false, columnDefinition = "boolean default false")
    private Boolean commentDeleteYn;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    @Builder
    public Comment(Long commentIdx,Post post, Long commentId, String commentWriterId, String commentContent,
                   LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.post = post;
//        this.post = Post.builder().postId(postId).build();
        this.commentId = commentId;
        this.commentWriterId = commentWriterId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }

    public void update( String commentConetent) {
        this.commentContent = commentConetent;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete( Boolean commentDeleteYn ){
        this.commentDeleteYn = true;
    }




}

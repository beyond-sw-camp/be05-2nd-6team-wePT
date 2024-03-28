package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.encore.apartment.community.domain.user.data.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@NoArgsConstructor
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentIdx;

    @Column(name = "comment_id" ,nullable = false)
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // 다대일 Comment -> User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @Column(name = "comment_content", nullable = false)
    private String commentContent;

    @Column(name = "comment_date" ,nullable = false)
    private LocalDateTime commentDate;

    @Column(name = "comment_delete_yn" ,nullable = false, columnDefinition = "boolean default false")
    private Boolean commentDeleteYn;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Long commentIdx,Post post, Long commentId, User user, String commentContent,
                   LocalDateTime commentDate, Boolean commentDeleteYn, LocalDateTime updatedAt){
        this.commentIdx = commentIdx;
        this.post = post;
        this.commentId = commentId;
        this.user = user;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentDeleteYn = commentDeleteYn;
        this.updatedAt = updatedAt;
    }

    public void update( String commentConetent) {
        this.commentContent = commentConetent;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete( ){
        this.commentDeleteYn = true;
        this.updatedAt = LocalDateTime.now();
    }




}

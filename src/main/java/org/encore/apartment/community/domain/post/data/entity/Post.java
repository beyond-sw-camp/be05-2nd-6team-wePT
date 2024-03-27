package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.encore.apartment.community.domain.user.data.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity // 객체 매핑
@Table(name="post")
@NoArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Long postId;

    // 일대다 단방향 Post -> Comment
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "post_category_id", nullable = false)
    private Long postCategoryId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    // 다대일 Post -> User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @Column(name = "post_content", nullable = false)
    private String postContent;

    @Column(name = "post_date", nullable = false)
    private LocalDateTime postDate;

    @Column(name = "post_recommend", nullable = false)
    private Integer postRecommend;

    @Column(name = "post_delete_yn", nullable = false, columnDefinition = "boolean default false")
    private Boolean postDeleteYn;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public Post(Long postId, Long postCategoryId, String postTitle
                ,String postContent, LocalDateTime postDate, Integer postRecommend
                ,Boolean postDeleteYn, LocalDateTime updatedAt , User user) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.postTitle = postTitle;
        this.user = user;
        this.postContent = postContent;
        this.postDate = postDate;
        this.postRecommend = postRecommend;
        this.postDeleteYn = postDeleteYn;
        this.updatedAt = updatedAt;
    }


    public void update(String postTitle, String postContent) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.postDeleteYn = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void recommend() {
        this.postRecommend++;
    }

}

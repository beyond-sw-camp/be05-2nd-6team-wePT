package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.*;

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

    // 일대다 단방향 -> Comment
    @OneToMany(mappedBy = "post")
    // @JoinColumn(name = "post_id") // Comment 테이블에 post_id 외래키 생성
    private List<Comment> comments = new ArrayList<>();

    @Column(name = "post_category_id", nullable = false)
    private Long postCategoryId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_writer_id", nullable = false)
    private String postWriterId;

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
    public Post(Long postId, Long postCategoryId, String postTitle, String postWriterId
                ,String postContent, LocalDateTime postDate, Integer postRecommend
                ,Boolean postDeleteYn, LocalDateTime updatedAt ) {
        this.postId = postId;
        this.postCategoryId = postCategoryId;
        this.postTitle = postTitle;
        this.postWriterId = postWriterId;
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
    }

    public void recommend() {
        this.postRecommend++;
    }

}

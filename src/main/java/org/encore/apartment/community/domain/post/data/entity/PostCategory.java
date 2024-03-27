package org.encore.apartment.community.domain.post.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "postcategory")
public class PostCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postCategoryId;

    @Column(name = "post_category_name", nullable = false)
    private String postCategoryName;

    @Builder
    public PostCategory(Long postCategoryId, String postCategoryName){
        this.postCategoryId = postCategoryId;
        this.postCategoryName = postCategoryName;
    }


}

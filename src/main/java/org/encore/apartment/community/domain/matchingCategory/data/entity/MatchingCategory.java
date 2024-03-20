package org.encore.apartment.community.domain.matchingCategory.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchingCategory_id")
    private Long matchingCategoryId;

    @NotBlank
    @Column(name = "matchingCategory_name")
    private String matchingCategoryName;

    @Builder
    public MatchingCategory(String matchingCategoryName) {
        this.matchingCategoryName = matchingCategoryName;
    }


    public void update(String matchingCategoryName){
        this.matchingCategoryName = matchingCategoryName;
    }
}

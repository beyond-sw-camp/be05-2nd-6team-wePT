package org.encore.apartment.community.domain.matching.data.entity;


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
    @Column(name = "apartment_id")
    private Long matching_id;

    @NotBlank
    @Column(name = "matching_name")
    private String matchingName;

    @Builder
    public MatchingCategory(String matchingName) {
        this.matchingName = matchingName;
    }


    public void update(String matchingName){
        this.matchingName = matchingName;
    }
}

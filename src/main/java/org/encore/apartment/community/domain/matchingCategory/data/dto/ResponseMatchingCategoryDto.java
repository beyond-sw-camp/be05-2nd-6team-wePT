package org.encore.apartment.community.domain.matchingCategory.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matching.data.entity.MatchingCategory;

@Data
public class ResponseMatchingCategoryDto {

    @NotNull
    private Long matchingCategoryId;

    @NotBlank
    private String matchingCategoryName;



    public ResponseMatchingCategoryDto(MatchingCategory params) {
                this.matchingCategoryId = params.getMatchingCategoryId();
                this.matchingCategoryName = params.getMatchingCategoryName();


    }



}
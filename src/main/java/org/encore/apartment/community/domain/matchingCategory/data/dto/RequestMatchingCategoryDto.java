package org.encore.apartment.community.domain.matchingCategory.data.dto;

import jakarta.validation.constraints.NotBlank;
import org.encore.apartment.community.domain.apartment.data.dto.RequestApartmentDto;
import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.matching.data.entity.MatchingCategory;

public class RequestMatchingCategoryDto {

    @NotBlank
    private String matchingCategoryName;

    public static MatchingCategory toEntity(RequestMatchingCategoryDto dto) {
        return MatchingCategory.builder()
                .matchingCategoryName(dto.matchingCategoryName)
                .build();
    }
}

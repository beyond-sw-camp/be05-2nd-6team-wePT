package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Getter;

@Data
public class RequestMatchingDto {



    @NotBlank
    private Integer matching_matchingCategory_id;

    @NotBlank
    private String matchingOwnerId;

    @NotBlank
    private Integer matchingHeadCountLimit;








    public static Matching toEntity(RequestMatchingDto dto) {
        return Matching.builder()
                .matchingMatchingId(dto.matching_matchingCategory_id)
                .matchingOwnerId(dto.matchingOwnerId)
                .matchingHeadCountLimit(dto.matchingHeadCountLimit)
                .build();

    }



}
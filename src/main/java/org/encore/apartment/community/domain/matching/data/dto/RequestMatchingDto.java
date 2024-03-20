package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Getter;

@Getter
class RequestMatchingDto {

    @NotBlank
    private Integer matchingId;

    @NotBlank
    private Integer mathcingMatchingId;

    @NotBlank
    private String matchingOwnerId;

    @NotBlank
    private Integer matchingHeadCountLimit;

    @NotBlank
    private String matching_accomplished_yn;

    @NotBlank
    private String matching_created_at;

    @NotBlank
    private String matching_updated_at;




    public static Matching toEntity(RequestMatchingDto dto) {
        return Matching.builder()
                .matchingId(dto.matchingId)
                .mathcingMatchingId(dto.mathcingMatchingId)
                .matchingOwnerId(dto.matchingOwnerId)
                .matchingHeadCountLimit(dto.matchingHeadCountLimit)
                .matching_accomplished_yn(dto.matching_accomplished_yn)
                .matching_created_at(dto.matching_created_at)
                .matching_updated_at(dto.matching_updated_at)
                .build();

    }



}
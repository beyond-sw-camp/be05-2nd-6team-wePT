package org.encore.apartment.community.domain.user.data.dto

import org.encore.apartment.community.domain.user.data.entity.Matching;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
class RequestMatchingDto {

    @NotNull
    private Integer matchingId;

    @NotNull
    private Integer mathcingMatchingId;

    @NotNull
    private String matchingOwnerId;

    @NotNull
    private Integer matchingHeadCountLimit;


    public static Matching toEntity(RequestMatchingDto matchingDto) {
        return Matching.builder()
                .matchingId(matchingDto.getMatchingId())
                .mathcingMatchingId(matchingDto.getMathcingMatchingId())
                .matchingOwnerId(matchingDto.getMatchingOwnerId())
                .matchingHeadCountLimit(matchingDto.getMatchingHeadCountLimit())
                .build();

    }



}
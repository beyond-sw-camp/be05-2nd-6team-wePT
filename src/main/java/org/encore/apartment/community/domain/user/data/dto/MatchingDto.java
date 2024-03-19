package org.encore.apartment.community.domain.user.data.dto

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.encore.apartment.community.domain.user.data.entity.Matching;

@Getter
class MatchingDto {

    @NotNull
    private Integer matchingId;

    @NotNull
    private Integer mathcingMatchingId;

    @NotNull
    private String matchingOwnerId;

    @NotNull
    private Integer matchingHeadCountLimit;


    public static Matching toEntity(MatchingDto matchingDto) {
        return Matching.builder()
                .matchingId(matchingDto.getMatchingId())
                .mathcingMatchingId(matchingDto.getMathcingMatchingId())
                .matchingOwnerId(matchingDto.getMatchingOwnerId())
                .matchingHeadCountLimit(matchingDto.getMatchingHeadCountLimit())
                .build();

    }



}
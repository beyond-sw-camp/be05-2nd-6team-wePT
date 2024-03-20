package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Getter;

@Data
public class RequestMatchingDto {

    @NotBlank
    private Integer matchingId;

    @NotBlank
    private Integer matchingMatchingId;

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
                .matchingMatchingId(dto.matchingMatchingId)
                .matchingOwnerId(dto.matchingOwnerId)
                .matchingHeadCountLimit(dto.matchingHeadCountLimit)
                .matchingAccomplishedYn(dto.matching_accomplished_yn)
                .matchingCreatedAt(dto.matching_created_at)
                .matchingUpdatedAt(dto.matching_updated_at)
                .build();

    }



}
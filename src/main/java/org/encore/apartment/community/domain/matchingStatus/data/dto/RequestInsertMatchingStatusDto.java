package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;


@Data
public class RequestInsertMatchingStatusDto {

    @NotNull
    private Integer matchingMatchingCategoryId;

    @NotBlank
    private String matchingOwnerId;

    @NotNull
    private Integer matchingHeadCountLimit;





    public static Matching toEntity(RequestInsertMatchingStatusDto requestInsertMatchingDto) {
        return Matching.builder()
                .matchingAccomplishedYn(false)
                .matchingMatchingCategoryId(requestInsertMatchingDto.getMatchingMatchingCategoryId())
                .matchingOwnerId(requestInsertMatchingDto.getMatchingOwnerId())
                .matchingHeadCountLimit(requestInsertMatchingDto.getMatchingHeadCountLimit())
                .build();
    }
}

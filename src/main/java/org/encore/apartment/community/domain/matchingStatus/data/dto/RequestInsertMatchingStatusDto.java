package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import lombok.NonNull;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;


@Data
public class RequestInsertMatchingStatusDto {


    private Long matchingStatusMatchingId;

    @NotBlank
    private String matchingStatusFollowerId;

    public static MatchingStatus toEntity(RequestInsertMatchingStatusDto requestInsertMatchingStatusDto) {
        return MatchingStatus.builder()
                .matchingStatusMatchingId(requestInsertMatchingStatusDto.getMatchingStatusMatchingId())
                .matchingStatusFollowerId(requestInsertMatchingStatusDto.getMatchingStatusFollowerId())
                .build();
    }
}
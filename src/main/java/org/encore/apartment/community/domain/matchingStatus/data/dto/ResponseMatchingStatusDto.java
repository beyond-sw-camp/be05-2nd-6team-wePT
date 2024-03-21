package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;

@Data
public class ResponseMatchingStatusDto {

    @NotNull
    private Long matchingStatusMatchingId;

    @NotBlank
    private String matchingStatusFollowerId;


    public ResponseMatchingStatusDto(MatchingStatus params) {
                this.matchingStatusMatchingId = params.getMatchingStatusMatchingId();
                this.matchingStatusFollowerId = params.getMatchingStatusFollowerId();

    }



}
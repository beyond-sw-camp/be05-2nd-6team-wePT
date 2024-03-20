package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

@Data
public class ResponseMatchingDto {

    @NotNull
    private Long matchingId;

    @NotBlank
    private Integer mathcingMatchingId;

    @NotBlank
    private String matchingOwnerId;

    @NotBlank
    private Integer matchingHeadCountLimit;


    private String matching_accomplished_yn;


    private String matching_created_at;


    private String matching_updated_at;


    public ResponseMatchingDto(Matching params) {
                this.matchingId = params.getMatching_id();
                this.mathcingMatchingId = params.getMatchingMatchingId();
                this.matchingOwnerId = params.getMatchingOwnerId();
                this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();
                this.matching_accomplished_yn = params.getMatchingAccomplishedYn();
                this.matching_created_at = params.getMatchingCreatedAt();
                this.matching_updated_at = params.getMatchingUpdatedAt();

    }



}
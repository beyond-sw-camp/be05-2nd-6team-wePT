package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

@Data
public class ResponseMatchingDto {

    @NotNull
    private Integer matchingId;

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
                this.matchingId = params.getmatchingId();
                this.mathcingMatchingId = params.getmathcingMatchingId();
                this.matchingOwnerId = params.getmatchingOwnerId();
                this.matchingHeadCountLimit = params.getmatchingHeadCountLimit();
                this.matching_accomplished_yn = params.getmatching_accomplished_yn();
                this.matching_created_at = params.getmatching_created_at();
                this.matching_updated_at = params.getmatching_updated_at();

    }



}
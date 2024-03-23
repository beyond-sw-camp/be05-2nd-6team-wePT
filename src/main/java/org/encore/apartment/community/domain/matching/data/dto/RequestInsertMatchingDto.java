package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;



@Getter
public class RequestInsertMatchingDto {

    @NotNull
    private Integer matchingMatchingCategoryId;

    @NotBlank
    private String matchingOwnerId;

    @NotNull
    private Integer matchingHeadCountLimit;

    @NotNull
    private Integer matchingAccomplishedYn;

    public static Matching toEntity(RequestInsertMatchingDto requestInsertMatchingDto) {
        return Matching.builder()
                .matchingMatchingCategoryId(requestInsertMatchingDto.getMatchingMatchingCategoryId())
                .userPassword(requestUserDto.getUserPassword())
                .userNickname(requestUserDto.getUserNickname())
                .userEmail(requestUserDto.getUserEmail())
                .userMobile(requestUserDto.getUserMobile())
                .userBuildingNumber(requestUserDto.getUserBuildingNumber())
                .userHouseNumber(requestUserDto.getUserHouseNumber())
                .userHeadHouseHoldYn(requestUserDto.getUserHeadHouseHoldYn())
                .build();
    }
}

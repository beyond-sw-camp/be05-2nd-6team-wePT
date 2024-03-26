package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestInsertMatchingDto {

	@NotNull
	private Integer matchingMatchingCategoryId;

	@NotBlank
	private String matchingOwnerId;

	@NotNull
	private Integer matchingHeadCountLimit;

	public static Matching toEntity(RequestInsertMatchingDto requestInsertMatchingDto) {
		return Matching.builder()
			.matchingAccomplishedYn(false)
			.matchingMatchingCategoryId(requestInsertMatchingDto.getMatchingMatchingCategoryId())
			.matchingOwnerId(requestInsertMatchingDto.getMatchingOwnerId())
			.matchingHeadCountLimit(requestInsertMatchingDto.getMatchingHeadCountLimit())
			.build();
	}
}

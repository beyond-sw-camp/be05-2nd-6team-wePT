package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotNull;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Data;

@Data
public class RequestSearchMatchingDto {

	@NotNull
	private Integer matchingMatchingCategoryId;



	@NotNull
	private Integer matchingHeadCountLimit;

	public static Matching toEntity(RequestSearchMatchingDto dto) {
		return Matching.builder()
			.matchingMatchingId(dto.matchingMatchingCategoryId)
			.matchingHeadCountLimit(dto.matchingHeadCountLimit)
			.build();

	}

}
package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestMatchingDto {

	private Integer matchingMatchingCategoryId;



	@NotBlank
	private Integer matchingHeadCountLimit;

	public static Matching toEntity(RequestMatchingDto dto) {
		return Matching.builder()
			.matchingMatchingId(dto.matchingMatchingCategoryId)
			.matchingHeadCountLimit(dto.matchingHeadCountLimit)
			.build();

	}

}
package org.encore.apartment.community.domain.matchingStatus.data.dto;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import jakarta.validation.constraints.NotBlank;

public class RequestMatchingCategoryDto {

	@NotBlank
	private String matchingCategoryName;

	public static MatchingCategory toEntity(RequestMatchingCategoryDto dto) {
		return MatchingCategory.builder()
			.matchingCategoryName(dto.matchingCategoryName)
			.build();
	}
}

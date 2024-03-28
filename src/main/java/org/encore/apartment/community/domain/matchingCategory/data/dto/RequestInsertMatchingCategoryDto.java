package org.encore.apartment.community.domain.matchingCategory.data.dto;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestInsertMatchingCategoryDto {

	@NotBlank
	private String matchingCategoryName;

	public static MatchingCategory toEntity(RequestInsertMatchingCategoryDto dto) {
		return MatchingCategory.builder()
			.matchingCategoryName(dto.matchingCategoryName)
			.build();
	}
}

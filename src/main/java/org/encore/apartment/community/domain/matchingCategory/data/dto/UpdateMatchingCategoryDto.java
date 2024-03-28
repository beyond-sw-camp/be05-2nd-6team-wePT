package org.encore.apartment.community.domain.matchingCategory.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateMatchingCategoryDto {
	@NotNull
	private Long matchingCategoryId;

	@NotBlank
	private String matchingCategoryName;
}

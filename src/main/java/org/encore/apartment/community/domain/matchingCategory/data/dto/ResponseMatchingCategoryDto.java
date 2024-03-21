package org.encore.apartment.community.domain.matchingCategory.data.dto;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseMatchingCategoryDto {

	@NotNull
	private Long matchingCategoryId;

	@NotBlank
	private String matchingCategoryName;

	public ResponseMatchingCategoryDto(MatchingCategory params) {
		this.matchingCategoryId = params.getMatchingCategoryId();
		this.matchingCategoryName = params.getMatchingCategoryName();

	}

}
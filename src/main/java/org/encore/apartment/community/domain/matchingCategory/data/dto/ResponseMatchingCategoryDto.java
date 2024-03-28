package org.encore.apartment.community.domain.matchingCategory.data.dto;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import lombok.Data;

@Data
public class ResponseMatchingCategoryDto {

	private Long matchingCategoryId;

	private String matchingCategoryName;

	public ResponseMatchingCategoryDto(MatchingCategory params) {
		this.matchingCategoryId = params.getMatchingCategoryId();
		this.matchingCategoryName = params.getMatchingCategoryName();

	}

}
package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateMatchingDto {

	private Long matchingCategoryId;

	private Integer matchingHeadCountLimit;

	public UpdateMatchingDto(Matching params) {

		this.matchingCategoryId = params.getMatchingCategory().getMatchingCategoryId();
		this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();

	}

}


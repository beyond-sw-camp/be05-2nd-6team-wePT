package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateMatchingDto {

	private MatchingCategory matchingMatchingCategoryId;

	private Integer matchingHeadCountLimit;

}


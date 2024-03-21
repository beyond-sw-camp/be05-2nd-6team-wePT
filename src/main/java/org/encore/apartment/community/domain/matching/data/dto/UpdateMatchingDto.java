package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateMatchingDto {
	@NotNull
	private Long matchingId;

	@NotBlank
	private Integer matchingMatchingCategoryId;

	@NotBlank
	private String matchingOwnerId;

	@NotBlank
	private Integer matchingHeadCountLimit;
	@NotBlank
	private String matchingAccomplishedYn;
	
	private String matchingCreatedAt;

	private String matchingUpdatedAt;
}

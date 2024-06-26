package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestInsertMatchingDto {

	@NotNull
	private Long matchingCategoryId;

	@NotBlank
	private String userId;

	@NotNull
	private Integer matchingHeadCountLimit;
}

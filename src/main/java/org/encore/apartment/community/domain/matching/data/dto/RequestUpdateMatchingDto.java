package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestUpdateMatchingDto {

	@NotNull
	private Long matchingCategoryId;

	@NotNull
	private Integer matchingHeadCountLimit;

}


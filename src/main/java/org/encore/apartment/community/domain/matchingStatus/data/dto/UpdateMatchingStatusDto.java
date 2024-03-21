package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateMatchingStatusDto {

	@NotNull
	private Long matchingStatusMatchingId;

	@NotBlank
	private String matchingStatusFollowerId;
}

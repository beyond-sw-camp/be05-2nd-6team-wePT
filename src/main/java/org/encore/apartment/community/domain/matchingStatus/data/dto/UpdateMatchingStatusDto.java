package org.encore.apartment.community.domain.matchingStatus.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateMatchingStatusDto {

	@NotNull
	private Matching matchingId;

	@NotBlank
	private User userId;
}

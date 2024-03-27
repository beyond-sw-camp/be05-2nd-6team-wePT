package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestInsertMatchingStatusDto {

	@NotNull
	private Long matchingId;

	@NotBlank
	private String userId;

}
package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestMatchingStatusDto {

	@NotBlank
	private String matchingStatusFollowerId;

	// public static MatchingStatus toEntity(RequestMatchingStatusDto dto) {
	// 	return MatchingStatus.builder()
	// 		.matchingStatusFollowerId(dto.matchingStatusFollowerId)
	// 		.build();
	// }
}

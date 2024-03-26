package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestInsertMatchingStatusDto {

	private Long matchingId;

	@NotBlank
	private String userId;

	// public static MatchingStatus toEntity(RequestInsertMatchingStatusDto requestInsertMatchingStatusDto) {
	//     return MatchingStatus.builder()
	//             .matchingStatusMatchingId(requestInsertMatchingStatusDto.getMatchingStatusMatchingId())
	//             .matchingStatusFollowerId(requestInsertMatchingStatusDto.getMatchingStatusFollowerId())
	//             .build();
	// }
}
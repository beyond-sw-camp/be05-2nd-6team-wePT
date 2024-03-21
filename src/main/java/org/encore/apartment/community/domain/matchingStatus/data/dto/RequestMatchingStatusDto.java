package org.encore.apartment.community.domain.matchingStatus.data.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;


@Data
public class RequestMatchingStatusDto {

	@NotBlank
	private String matchingStatusFollowerId;

	public static MatchingStatus toEntity(RequestMatchingStatusDto dto) {
		return MatchingStatus.builder()
			.matchingStatusFollowerId(dto.matchingStatusFollowerId)
			.build();
	}
}

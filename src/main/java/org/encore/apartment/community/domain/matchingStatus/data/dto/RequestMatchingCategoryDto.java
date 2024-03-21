package org.encore.apartment.community.domain.matchingStatus.data.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

import jakarta.validation.constraints.NotBlank;


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

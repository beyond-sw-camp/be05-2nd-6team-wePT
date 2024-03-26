package org.encore.apartment.community.domain.matchingStatus.data.dto;

import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseMatchingStatusDto {

	@NotNull
	private Long matchingStatusMatchingId;

	@NotBlank
	private User matchingStatusFollowerId;

	public ResponseMatchingStatusDto(MatchingStatus params) {
		this.matchingStatusMatchingId = params.getMatchingStatusMatchingId();
		this.matchingStatusFollowerId = params.getMatchingStatusFollowerId();

	}

}
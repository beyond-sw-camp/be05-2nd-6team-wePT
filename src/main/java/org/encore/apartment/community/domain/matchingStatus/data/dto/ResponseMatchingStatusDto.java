package org.encore.apartment.community.domain.matchingStatus.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseMatchingStatusDto {

	@NotNull
	private Matching matchingId;

	@NotBlank
	private User userId;

	public ResponseMatchingStatusDto(MatchingStatus params) {
		this.matchingId = params.getMatching();
		this.userId = params.getUser();

	}

}
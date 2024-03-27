package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResponseClosedMatchingDto {

	@NotNull
	private Long matchingId;

	@NotNull
	private Integer matchingHeadCountLimit;

	// private List<MatchingStatus> userId;

	public ResponseClosedMatchingDto(Long matchingId, Integer matchingHeadCountLimit) {
		this.matchingId = matchingId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

	public ResponseClosedMatchingDto(Matching matching) {
		this.matchingId = matching.getMatchingId();
		this.matchingHeadCountLimit = matching.getMatchingHeadCountLimit();
	}
}
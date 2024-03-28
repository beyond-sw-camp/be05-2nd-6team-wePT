package org.encore.apartment.community.domain.matching.data.dto;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ResponseClosedMatchingDto {

	private Long matchingId;

	private Integer matchingHeadCountLimit;

	private List<String> userIdList;

	public ResponseClosedMatchingDto(Long matchingId, Integer matchingHeadCountLimit) {
		this.matchingId = matchingId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

	public ResponseClosedMatchingDto(Long matchingId, Integer matchingHeadCountLimit, List<String> userId) {
		this.matchingId = matchingId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
		this.userIdList = userId;
	}

	public ResponseClosedMatchingDto(Matching matching) {
		this.matchingId = matching.getMatchingId();
		this.matchingHeadCountLimit = matching.getMatchingHeadCountLimit();

	}

}
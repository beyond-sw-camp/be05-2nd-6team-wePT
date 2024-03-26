package org.encore.apartment.community.domain.matching.data.dto;

import java.util.List;

import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseClosedMatchingDto {

	@NotNull
	private Long matchingId;

	@NotNull
	private Integer matchingHeadCountLimit;

	private List<MatchingStatus> userId;

	public ResponseClosedMatchingDto(ResponseClosedMatchingDto responseClosedMatchingDto) {
		this.matchingId = responseClosedMatchingDto.getMatchingId();
		this.matchingHeadCountLimit = responseClosedMatchingDto.getMatchingHeadCountLimit();

	}

}
package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotNull;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Data;

@Data
public class RequestSearchMatchingDto {

	@NotNull
	private Long matchingId;




	public static Matching toEntity(RequestSearchMatchingDto requestSearchMatchingDto) {
		return Matching.builder()
//			.matchingId(requestSearchMatchingDto.getMatchingId())
			.build();

	}

}
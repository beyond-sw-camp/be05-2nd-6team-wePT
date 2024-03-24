package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;

@Data
public class UpdateMatchingDto {



	private Integer matchingMatchingCategoryId;


	private Integer matchingHeadCountLimit;




	public static Matching toEntity(UpdateMatchingDto updateMatchingDto) {
		return Matching.builder()
				.matchingMatchingCategoryId(updateMatchingDto.getMatchingMatchingCategoryId())
				.matchingHeadCountLimit(updateMatchingDto.getMatchingHeadCountLimit())

				.build();
	}

}

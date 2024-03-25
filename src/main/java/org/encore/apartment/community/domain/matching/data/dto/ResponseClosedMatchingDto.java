package org.encore.apartment.community.domain.matching.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.user.data.entity.User;
import java.util.List;
import java.sql.Timestamp;

@Data
public class ResponseClosedMatchingDto {

	@NotNull
	private Long matchingId;

	@NotNull
	private List<MatchingCategory> matchingMatchingCategoryId;


	@NotNull
	private Integer matchingHeadCountLimit;



//	public ResponseClosedMatchingDto(Matching params) {
//		this.matchingId = params.getMatchingId();
//		this.matchingMatchingCategoryId = params.getMatchingMatchingCategoryId();
//		this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();
//	}

	public ResponseClosedMatchingDto(Long matchingId, List<MatchingCategory> matchingMatchingCategoryId, Integer matchingHeadCountLimit) {
		this.matchingId = matchingId;
		this.matchingMatchingCategoryId = matchingMatchingCategoryId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
	}

}
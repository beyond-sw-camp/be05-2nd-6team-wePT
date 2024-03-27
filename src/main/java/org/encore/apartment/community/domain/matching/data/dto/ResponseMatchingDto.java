package org.encore.apartment.community.domain.matching.data.dto;

import java.sql.Timestamp;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseMatchingDto {

	private Long matchingId;

	private Integer matchingHeadCountLimit;

	private Boolean matchingAccomplishedYn;

	private Timestamp matchingCreatedAt;

	private Timestamp matchingUpdatedAt;

	private Long userIdx;

	private String userId;

	private Long matchingCategoryId;

	private String matchingCategoryName;

	public ResponseMatchingDto(Matching params) {
		this.matchingId = params.getMatchingId();
		this.matchingCategoryId = params.getMatchingCategory().getMatchingCategoryId();
		this.matchingCategoryName = params.getMatchingCategory().getMatchingCategoryName();
		this.userIdx = params.getUser().getUserIdx();
		this.userId = params.getUser().getUserId();
		this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();
		this.matchingAccomplishedYn = params.getMatchingAccomplishedYn();
		this.matchingCreatedAt = params.getMatchingCreatedAt();
		this.matchingUpdatedAt = params.getMatchingUpdatedAt();
	}

}
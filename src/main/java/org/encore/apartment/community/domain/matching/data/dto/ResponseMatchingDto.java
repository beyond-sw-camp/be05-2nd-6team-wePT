package org.encore.apartment.community.domain.matching.data.dto;

import java.sql.Timestamp;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseMatchingDto {

	@NotNull
	private Long matchingId;

	@NotNull
	private MatchingCategory matchingCategoryId;

	@NotBlank
	private User userId;

	@NotNull
	private Integer matchingHeadCountLimit;

	private Boolean matchingAccomplishedYn;

	private Timestamp matchingCreatedAt;

	private Timestamp matchingUpdatedAt;

	public ResponseMatchingDto(
		Long matchingId, MatchingCategory matchingCategoryId,
		User userId, Integer matchingHeadCountLimit,
		Boolean matchingAccomplishedYn, Timestamp matchingCreatedAt,
		Timestamp matchingUpdatedAt
	) {
		this.matchingId = matchingId;
		this.matchingCategoryId = matchingCategoryId;
		this.userId = userId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
		this.matchingAccomplishedYn = matchingAccomplishedYn;
		this.matchingCreatedAt = matchingCreatedAt;
		this.matchingUpdatedAt = matchingUpdatedAt;
	}

	public ResponseMatchingDto(Matching params) {
		this.matchingId = params.getMatchingId();
		this.matchingCategoryId = params.getMatchingCategoryId();
		this.userId = params.getUserId();
		this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();
		this.matchingAccomplishedYn = params.getMatchingAccomplishedYn();
		this.matchingCreatedAt = params.getMatchingCreatedAt();
		this.matchingUpdatedAt = params.getMatchingUpdatedAt();

	}

}
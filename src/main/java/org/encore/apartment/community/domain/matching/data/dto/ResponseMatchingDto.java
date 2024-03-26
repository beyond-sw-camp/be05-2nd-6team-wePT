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
	private MatchingCategory matchingMatchingCategoryId;

	@NotBlank
	private User matchingOwnerId;

	@NotNull
	private Integer matchingHeadCountLimit;

	private Boolean matchingAccomplishedYn;

	private Timestamp matchingCreatedAt;

	private Timestamp matchingUpdatedAt;

	public ResponseMatchingDto(Matching params) {
		this.matchingId = params.getMatchingId();
		this.matchingMatchingCategoryId = params.getMatchingMatchingCategoryId();
		this.matchingOwnerId = params.getMatchingOwnerId();
		this.matchingHeadCountLimit = params.getMatchingHeadCountLimit();
		this.matchingAccomplishedYn = params.getMatchingAccomplishedYn();
		this.matchingCreatedAt = params.getMatchingCreatedAt();
		this.matchingUpdatedAt = params.getMatchingUpdatedAt();

	}

}
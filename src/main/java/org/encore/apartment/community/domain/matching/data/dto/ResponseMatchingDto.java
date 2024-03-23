package org.encore.apartment.community.domain.matching.data.dto;

import org.encore.apartment.community.domain.matching.data.entity.Matching;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResponseMatchingDto {

	@NotNull
	private Long matchingId;

	@NotNull
	private Integer matchingMatchingCategoryId;

	@NotBlank
	private String matchingOwnerId;

	@NotNull
	private Integer matchingHeadCountLimit;

	private String matchingAccomplishedYn;

	private String matchingCreatedAt;

	private String matchingUpdatedAt;

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
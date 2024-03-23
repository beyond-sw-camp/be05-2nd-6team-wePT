package org.encore.apartment.community.domain.matching.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Matching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matching_id")
	private Long matchingId;

	@NotNull
	@Column(name = "matching_matchingCategory_id")
	private Integer matchingMatchingCategoryId;

	@NotBlank
	@Column(name = "matching_owner_id")
	private String matchingOwnerId;

	@NotNull
	@Column(name = "matching_head_count_limit")
	private Integer matchingHeadCountLimit;

	@NotBlank
	@Column(name = "matching_accomplished_yn")
	private String matchingAccomplishedYn;

	@NotBlank
	@Column(name = "matching_created_at")
	private String matchingCreatedAt;

	@NotBlank
	@Column(name = "matching_updated_at")
	private String matchingUpdatedAt;

	@Builder
	public Matching(
		Integer matchingMatchingId, String matchingOwnerId, Integer matchingHeadCountLimit,
		String matchingAccomplishedYn, String matchingCreatedAt, String matchingUpdatedAt) {
		this.matchingMatchingCategoryId = matchingMatchingId;
		this.matchingOwnerId = matchingOwnerId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
		this.matchingAccomplishedYn = matchingAccomplishedYn;
		this.matchingCreatedAt = matchingCreatedAt;
		this.matchingUpdatedAt = matchingUpdatedAt;
	}

	public void update(Integer matchingMatchingCategoryId, Integer matchingHeadCountLimit) {
		this.matchingMatchingCategoryId = matchingMatchingCategoryId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

}

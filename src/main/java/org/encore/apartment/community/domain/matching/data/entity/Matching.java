package org.encore.apartment.community.domain.matching.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Long idx;

	@NotNull
	@Column(name = "matching_id")
	private Integer matchingId;

	@NotNull
	@Column(name = "matching_matching_id")
	private String matchingMatchingId;

	@NotNull
	@Column(name = "matching_owner_id")
	private String matchingOwnerId;

	@NotNull
	@Column(name = "matching_head_count_limit")
	private Integer matchingHeadCountLimit;

	@Builder
	public Matching(
		Long idx, Integer matchingId, String matchingMatchingId,
		String matchingOwnerId, Integer matchingHeadCountLimit) {
		this.idx = idx;
		this.matchingId = matchingId;
		this.matchingMatchingId = matchingMatchingId;
		this.matchingOwnerId = matchingOwnerId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
	}

}

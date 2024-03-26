package org.encore.apartment.community.domain.matchingStatus.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matchingStatus_idx")
	private Long matchingStatusIdx;

	@Column(name = "matchingStatus_matching_id")
	private Long matchingStatusMatchingId;

	@Column(name = "matchingStatus_follower_id")
	private String matchingStatusFollowerId;

	@Builder
	public MatchingStatus(Long matchingStatusMatchingId, String matchingStatusFollowerId) {
		this.matchingStatusMatchingId = matchingStatusMatchingId;
		this.matchingStatusFollowerId = matchingStatusFollowerId;
	}

	public void update(String matchingStatusFollowerId) {

		this.matchingStatusFollowerId = matchingStatusFollowerId;
	}
}


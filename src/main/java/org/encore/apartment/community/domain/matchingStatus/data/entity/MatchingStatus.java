package org.encore.apartment.community.domain.matchingStatus.data.entity;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.user.data.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matchingStatus_idx")
	private Long matchingStatusIdx;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matching_id")
	private Matching matchingStatusMatchingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User matchingStatusFollowerId;

	@Builder
	public MatchingStatus(Matching matchingStatusMatchingId, User matchingStatusFollowerId) {
		this.matchingStatusMatchingId = matchingStatusMatchingId;
		this.matchingStatusFollowerId = matchingStatusFollowerId;
	}

	public void update(User matchingStatusFollowerId) {

		this.matchingStatusFollowerId = matchingStatusFollowerId;
	}
}


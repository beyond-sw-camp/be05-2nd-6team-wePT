package org.encore.apartment.community.domain.matching.data.entity;

import java.sql.Timestamp;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

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
// updatebyid가 안되어 setter 추가
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Matching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matching_id")
	private Long matchingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matchingCategory_id", referencedColumnName = "matchingCategory_id")
	private MatchingCategory matchingCategory;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Column(name = "matching_head_count_limit")
	private Integer matchingHeadCountLimit;

	@Column(name = "matching_accomplished_yn", columnDefinition = "boolean default false")
	@ColumnDefault("false")
	private Boolean matchingAccomplishedYn;

	@Column(name = "matching_created_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp matchingCreatedAt;

	@Column(name = "matching_updated_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp matchingUpdatedAt;

	@Builder
	public Matching(
		Long matchingId,
		Integer matchingHeadCountLimit, MatchingCategory matchingCategory, User user,
		Boolean matchingAccomplishedYn, Timestamp matchingCreatedAt, Timestamp matchingUpdatedAt) {
		this.matchingId = matchingId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
		this.matchingCategory = matchingCategory;
		this.user = user;
		this.matchingAccomplishedYn = matchingAccomplishedYn;
		this.matchingCreatedAt = matchingCreatedAt;
		this.matchingUpdatedAt = matchingUpdatedAt;
	}

	public void update(MatchingCategory matchingCategory, Integer matchingHeadCountLimit) {
		this.matchingCategory = matchingCategory;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
	}
}

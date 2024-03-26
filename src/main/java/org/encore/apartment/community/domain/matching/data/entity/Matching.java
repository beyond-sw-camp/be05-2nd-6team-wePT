package org.encore.apartment.community.domain.matching.data.entity;

import java.sql.Timestamp;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.user.data.entity.User;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
// updatebyid가 안되어 setter 추가
@Setter
// @NamedEntityGraphs({
// 	@NamedEntityGraph(
// 		name = "matchingWithCategoryAndOwner",
// 		attributeNodes = {
// 			@NamedAttributeNode(value = "matchingCategoryId", subgraph = "matchingCategory"),
// 			@NamedAttributeNode(value = "userId", subgraph = "matchingOwner")
// 		},
// 		subgraphs = {
// 			@NamedSubgraph(
// 				name = "matchingCategory",
// 				attributeNodes = {
// 					@NamedAttributeNode("matchingCategoryId")
// 				}
// 			),
// 			@NamedSubgraph(
// 				name = "matchingOwner",
// 				attributeNodes = {
// 					@NamedAttributeNode("userId")
// 				}
// 			)
// 		}
// 	)
// })
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Matching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matching_id")
	private Long matchingId;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "matchingCategory_id")

	private MatchingCategory matchingCategoryId;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_id")
	private User userId;

	@Column(name = "matching_head_count_limit")
	private Integer matchingHeadCountLimit;

	//	@Column(name = "matching_accomplished_yn",   columnDefinition = "boolean default false")
	//	private Boolean matchingAccomplishedYn;

	@Column(name = "matching_accomplished_yn"
		, columnDefinition = "boolean default false"
	)
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
		Long matchingId, MatchingCategory matchingCategoryId, User userId,
		Integer matchingHeadCountLimit,
		Boolean matchingAccomplishedYn, Timestamp matchingCreatedAt, Timestamp matchingUpdatedAt) {
		this.matchingId = matchingId;
		this.matchingCategoryId = matchingCategoryId;
		this.userId = userId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;
		this.matchingAccomplishedYn = matchingAccomplishedYn;
		this.matchingCreatedAt = matchingCreatedAt;
		this.matchingUpdatedAt = matchingUpdatedAt;
	}

	public void update(MatchingCategory matchingCategoryId, Integer matchingHeadCountLimit) {
		this.matchingCategoryId = matchingCategoryId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

	public void insert(RequestInsertMatchingDto params) {
		this.matchingCategoryId = matchingCategoryId;
		this.userId = userId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

}

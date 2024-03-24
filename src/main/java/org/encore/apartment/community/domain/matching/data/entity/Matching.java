package org.encore.apartment.community.domain.matching.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

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


	@Column(name = "matching_matching_category_id")
	private Integer matchingMatchingCategoryId;


	@Column(name = "matching_owner_id")
	private String matchingOwnerId;


	@Column(name = "matching_head_count_limit")
	private Integer matchingHeadCountLimit;


//	@Column(name = "matching_accomplished_yn",   columnDefinition = "boolean default false")
//	private Boolean matchingAccomplishedYn;

	@Column(name = "matching_accomplished_yn",columnDefinition = "boolean default false")
	private Boolean matchingAccomplishedYn;


	@Column(name = "matching_created_at",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp matchingCreatedAt;


	@Column(name = "matching_updated_at", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
	@CreationTimestamp
	private Timestamp  matchingUpdatedAt;

	@Builder
	public Matching(
		Integer matchingMatchingId, Integer matchingMatchingCategoryId,String matchingOwnerId, Integer matchingHeadCountLimit,
		Boolean matchingAccomplishedYn, Timestamp  matchingCreatedAt, Timestamp  matchingUpdatedAt) {
		this.matchingId=matchingId;
		this.matchingMatchingCategoryId = matchingMatchingCategoryId;
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

	public void insert(RequestInsertMatchingDto params) {
		this.matchingMatchingCategoryId = matchingMatchingCategoryId;
		this.matchingOwnerId = matchingOwnerId;
		this.matchingHeadCountLimit = matchingHeadCountLimit;

	}

}

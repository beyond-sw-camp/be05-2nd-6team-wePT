package org.encore.apartment.community.domain.matchingCategory.data.entity;

import org.encore.apartment.community.domain.matchingCategory.data.dto.RequestInsertMatchingCategoryDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MatchingCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matchingCategory_id")
	private Long matchingCategoryId;

	@NotBlank
	@Column(name = "matchingCategory_name")
	private String matchingCategoryName;

	@Builder
	public MatchingCategory(Long matchingCategoryId, String matchingCategoryName) {
		this.matchingCategoryId = matchingCategoryId;
		this.matchingCategoryName = matchingCategoryName;
	}

	public void insert(RequestInsertMatchingCategoryDto params) {
		this.matchingCategoryName = matchingCategoryName;
	}

	public void update(String matchingCategoryName) {
		this.matchingCategoryName = matchingCategoryName;
	}
}

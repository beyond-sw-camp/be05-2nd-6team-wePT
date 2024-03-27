package org.encore.apartment.community.domain.matchingCategory.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matchingCategory.data.dto.RequestInsertMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.ResponseMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.UpdateMatchingCategoryDto;

public interface MatchingCategoryService {
	void insertMatchingCategoryInfo(RequestInsertMatchingCategoryDto params);

	Optional<ResponseMatchingCategoryDto> findMatchingCategoryInfo(Long id);

	List<ResponseMatchingCategoryDto> findMatchingCategoryInfoList();

	void updateMatchingCategoryInfoById(Long id, UpdateMatchingCategoryDto params);

	void deleteMatchingCategoryInfo(Long id);
}

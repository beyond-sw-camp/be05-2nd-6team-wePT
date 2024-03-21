package org.encore.apartment.community.domain.matchingCategory.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.matchingCategory.data.dto.RequestMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.ResponseMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.UpdateMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.matchingCategory.data.repository.MatchingCategoryRepository;
import org.springframework.stereotype.Service;


@Slf4j
@Service("matchingCategory")
@RequiredArgsConstructor
public class MatchingCategoryServiceImpl implements MatchingCategoryService {
	private final MatchingCategoryRepository matchingCategoryRepository;


	@Override
	public void insertMatchingCategoryInfo(RequestMatchingCategoryDto params) {
		MatchingCategory matchingCategory = RequestMatchingCategoryDto.toEntity(params);
		matchingCategoryRepository.save(matchingCategory);
		log.info("insertMatchingCategoryInfo = {}", matchingCategory);
	}


	@Override
	public Optional<ResponseMatchingCategoryDto> findMatchingCategoryInfo(Long id) {
		Optional<MatchingCategory> matchingCategory = matchingCategoryRepository.findById(id);
		log.info("findMatchingCategoryInfo = {}", matchingCategory);

		return matchingCategory.map(ResponseMatchingCategoryDto::new);
	}

	@Override
	public List<ResponseMatchingCategoryDto> findMatchingCategoryInfoList() {
		List<MatchingCategory> matchingCategoryList = matchingCategoryRepository.findAll();
		log.info("findMatchingCategoryInfoList = {}", matchingCategoryList);

		return matchingCategoryList.stream().map(ResponseMatchingCategoryDto::new).collect(Collectors.toList());
	}

	@Override
	public void updateMatchingCategoryInfoById(Long id, UpdateMatchingCategoryDto params) {
		MatchingCategory matchingCategory = matchingCategoryRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 매칭분류 정보가 없습니다."));
		matchingCategory.update(matchingCategory.getMatchingCategoryName());
		log.info("updateMatchingCategoryInfo = {}", params);
	}

	@Override
	public void deleteMatchingCategoryInfo(Long id) {
		matchingCategoryRepository.deleteById(id);
		log.info("deleteMatchingCategoryInfo = {}", id);
	}
}

package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.RequestSearchMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matching.data.repository.MatchingRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service("matching")
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

	private final MatchingRepository matchingRepository;



	@Override
	public void insertMatchingInfo(RequestInsertMatchingDto params) {
		Matching matching = RequestInsertMatchingDto.toEntity(params);
		matchingRepository.save(matching);
		log.info("insertMatchingInfo = {}", matching);
	}

	@Override
	public Optional<ResponseMatchingDto> findMatchingInfo(Long id) {
		 Optional<Matching> matching = matchingRepository.findById(id);
		 log.info("findMatchingInfo = {}", matching);

		 return matching.map(ResponseMatchingDto::new);

	}

	@Override
	public List<ResponseMatchingDto> findMatchingInfoList() {
		 List<Matching> matchingList = matchingRepository.findAll();
		 log.info("findApartmentInfoList = {}", matchingList);

		 return matchingList.stream().map(ResponseMatchingDto::new).collect(Collectors.toList());
	}

	@Override
	public void updateMatchingInfoById(Long id, UpdateMatchingDto params) {
		 Matching matching = matchingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 매칭 정보가 없습니다."));
		 matching.update(matching.getMatchingMatchingCategoryId(), matching.getMatchingHeadCountLimit());
		 log.info("updateApartmentInfo = {}", params);

	}

	@Override
	public void deleteMatchingInfo(Long id) {
		matchingRepository.deleteById(id);
		log.info("deleteMatchingInfo = {}", id);
	}
}

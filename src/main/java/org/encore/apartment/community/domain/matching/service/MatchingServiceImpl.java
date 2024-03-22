package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matching.data.dto.RequestMatchingDto;
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

	public MatchingServiceImpl(MatchingRepository matchingRepository) {
		this.matchingRepository = matchingRepository;
	}

	@Override
	public void insertMatchingInfo(RequestMatchingDto params) {
		Matching matching = RequestMatchingDto.toEntity(params);
		matchingRepository.save(matching);
		log.info("insertMatchingInfo = {}", matching);
	}

	@Override
	public Optional<ResponseMatchingDto> findMatchingInfo(Long id) {
		// Optional<Matching> matching = MatchingRepository.findById(id);
		// log.info("findMatchingInfo = {}", matching);
		//
		// return matching.map(ResponseMatchingDto::new);
		return null;
	}

	@Override
	public List<ResponseMatchingDto> findMatchingInfoList() {
		// List<Matching> matchingList = MatchingRepository.findAll();
		// log.info("findApartmentInfoList = {}", matchingList);
		//
		// return aptList.stream().map(ResponseApartmentDto::new).collect(Collectors.toList());
		return null;
	}

	@Override
	public void updateMatchingInfoById(Long id, UpdateMatchingDto params) {
		// Matching matching = MatchingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 매칭 정보가 없습니다."));
		// matching.update(matching.getMatchingMatchingCategoryId(), matching.getApartmentAddress(), apartment.getApartmentTotalHousehold());
		// log.info("updateApartmentInfo = {}", params);

	}

	@Override
	public void deleteMatchingInfo(Long id) {

	}
}

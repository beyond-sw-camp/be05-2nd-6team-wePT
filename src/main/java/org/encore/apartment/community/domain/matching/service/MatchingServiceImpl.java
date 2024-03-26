package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matching.data.repository.MatchingRepository;
import org.encore.apartment.community.domain.matchingCategory.data.repository.MatchingCategoryRepository;
import org.encore.apartment.community.domain.matchingStatus.data.repository.MatchingStatusRepository;
import org.encore.apartment.community.domain.user.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("matching")
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

	private final MatchingRepository matchingRepository;
	private final MatchingCategoryRepository matchingCategoryRepository;
	private final UserRepository userRepository;
	private final MatchingStatusRepository matchingStatusRepository;

	public Matching toEntity(RequestInsertMatchingDto requestInsertMatchingDto) {
		return Matching.builder()
			.matchingAccomplishedYn(false)
			.matchingCategoryId(
				matchingCategoryRepository.findById(requestInsertMatchingDto.getMatchingCategoryId()).get())
			.userId(userRepository.findByUserId(requestInsertMatchingDto.getUserId()).get())
			.matchingHeadCountLimit(requestInsertMatchingDto.getMatchingHeadCountLimit())
			.build();
	}

	@Override
	public void insertMatchingInfo(RequestInsertMatchingDto params) {
		Matching matching = toEntity(params);
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
		Matching matching = matchingRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("해당 매칭 정보가 없습니다."));
		//		matching.update(matching.getMatchingMatchingCategoryId(), matching.getMatchingHeadCountLimit());

		//		update가 안되어 matching에 setter 추가하고 아래와 같이 새로운 3개 line 추가함
		matching.setMatchingCategoryId((params.getMatchingCategoryId()));
		matching.setMatchingHeadCountLimit(params.getMatchingHeadCountLimit());
		matchingRepository.save(matching);
		log.info("updateApartmentInfo = {}", params);

	}

	@Override
	public void deleteMatchingInfo(Long id) {
		matchingRepository.deleteById(id);
		log.info("deleteMatchingInfo = {}", id);
	}

	@Override
	public List<ResponseClosedMatchingDto> findClosedMatchingInfo() {
		List<ResponseClosedMatchingDto> matching = matchingRepository.findClosedMatchingInfo();
		log.info("findClosedMatchingInfoList={}", matching);
		return matching.stream().map(ResponseClosedMatchingDto::new).collect(Collectors.toList());

	}

}



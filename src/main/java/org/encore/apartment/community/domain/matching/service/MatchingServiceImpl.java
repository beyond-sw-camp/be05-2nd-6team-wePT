package org.encore.apartment.community.domain.matching.service;

import java.util.ArrayList;
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
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.encore.apartment.community.domain.matchingStatus.data.repository.MatchingStatusRepository;
import org.encore.apartment.community.domain.user.repository.UserRepository;
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
			.matchingCategory(
				matchingCategoryRepository.findById(requestInsertMatchingDto.getMatchingCategoryId()).get())
			.user(userRepository.findByUserId(requestInsertMatchingDto.getUserId()).get())
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
	public ResponseMatchingDto findMatchingInfo(Long id) {
		Optional<Matching> matching = matchingRepository.findById(id);

		log.info("findMatchingInfo = {}", matching);

		// return matching.map(ResponseMatchingDto::new);

		return new ResponseMatchingDto(matching.get());

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
		matching.setMatchingCategory();
		matching.setMatchingHeadCountLimit(params.getMatchingHeadCountLimit());
		matchingRepository.save(matching);
		log.info("updateApartmentInfo = {}", params);

	}

	@Override
	public void deleteMatchingInfo(Long id) {
		matchingRepository.deleteById(id);
		log.info("deleteMatchingInfo = {}", id);
	}

	// 매칭현황 인원 리스트 만들기
	//List<User> user = new ArrayList<>();
	//,matching status repostory 호출
	// status repository -> findallbymatchingid
	// entity.getUserId -> List
	// list (entity) -> list(dto) (return)

	public List<String> getUsersOfMatching(Long matchingId) {
		Matching matching = matchingRepository.findById(matchingId).get();
		List<MatchingStatus> tmp = matchingStatusRepository.findAllByMatching(matching);
		List<String> list = new ArrayList<>();
		for (MatchingStatus matchingStatus : tmp) {
			list.add(matchingStatus.getUser().getUserId());
		}

		return list;
	}

	@Override
	public ResponseClosedMatchingDto findClosedMatchingInfo(Long id) {
		Optional<Matching> matching = matchingRepository.findById(id);
		Integer matchingHeadCountLimit = matching.get().getMatchingHeadCountLimit();
		List<String> list = getUsersOfMatching(id);// 참여한 사용자의 id 리스트

		log.info("findClosedMatchingInfoList={}", matching);
		// return matching.stream().map(ResponseClosedMatchingDto::new).collect(Collectors.toList());
		ResponseClosedMatchingDto dto = new ResponseClosedMatchingDto();
		dto.setMatchingId(id);
		dto.setMatchingHeadCountLimit(matchingHeadCountLimit);
		dto.setUserIdList(list);

		return dto;

	}

}



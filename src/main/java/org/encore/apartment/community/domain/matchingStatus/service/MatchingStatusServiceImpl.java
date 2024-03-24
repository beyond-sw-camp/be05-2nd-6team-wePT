package org.encore.apartment.community.domain.matchingStatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestInsertMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.ResponseMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.UpdateMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.encore.apartment.community.domain.matchingStatus.data.repository.MatchingStatusRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("matchingStatus")
@RequiredArgsConstructor
public class MatchingStatusServiceImpl implements MatchingStatusService {

	private final MatchingStatusRepository matchingStatusRepository;

	@Override
	public void insertMatchingStatusInfo(RequestInsertMatchingStatusDto params) {
		MatchingStatus matchingStatus = RequestInsertMatchingStatusDto.toEntity(params);
		matchingStatusRepository.save(matchingStatus);
		log.info("insertMatchingStatusInfo = {}", matchingStatus);
	}


	@Override
	public Optional<ResponseMatchingStatusDto> findMatchingStatusInfo(Long id) {
		Optional<MatchingStatus> matchingStatus = matchingStatusRepository.findById(id);
		log.info("findMatchingStatusInfo = {}", matchingStatus);

		return matchingStatus.map(ResponseMatchingStatusDto::new);
	}

	@Override
	public List<ResponseMatchingStatusDto> findMatchingStatusInfoList() {
		List<MatchingStatus> matchingStatusList = matchingStatusRepository.findAll();
		log.info("findMatchingStatusInfoList = {}", matchingStatusList);

		return matchingStatusList.stream().map(ResponseMatchingStatusDto::new).collect(Collectors.toList());
	}
	
	
//	업데이트 할만한 정보가 없어 구현하지 않음
	@Override
	public void updateMatchingStatusInfoById(Long id, UpdateMatchingStatusDto params) {
//		MatchingStatus matchingStatus = matchingStatusRepository.findById(id)
//			.orElseThrow(() -> new IllegalArgumentException("해당 매칭현황 정보가 없습니다."));
//		matchingStatus.update(matchingStatus.getMatchingStatusMatchingId(),
//			matchingStatus.getMatchingStatusFollowerId());
//		log.info("updateMatchingStatusInfo = {}", params);
	}

	@Override
	public void deleteMatchingStatusInfo(Long id) {
		matchingStatusRepository.deleteById(id);
		log.info("deleteMatchingStatusInfo = {}", id);
	}
}

package org.encore.apartment.community.domain.matchingStatus.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestInsertMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.ResponseMatchingStatusDto;

public interface MatchingStatusService {

	void insertMatchingStatusInfo(RequestInsertMatchingStatusDto params);

	Optional<ResponseMatchingStatusDto> findMatchingStatusInfo(Long id);

	List<ResponseMatchingStatusDto> findMatchingStatusInfoList();

	void deleteMatchingStatusInfo(Long id);
}

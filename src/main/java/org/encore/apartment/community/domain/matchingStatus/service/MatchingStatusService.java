package org.encore.apartment.community.domain.matchingStatus.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.ResponseMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.UpdateMatchingStatusDto;

public interface MatchingStatusService {

	public void insertMatchingStatusInfo(RequestMatchingStatusDto params);

	public Optional<ResponseMatchingStatusDto> findMatchingStatusInfo(Long id);

	public List<ResponseMatchingStatusDto> findMatchingStatusInfoList();

	public void updateMatchingStatusInfoById(Long id, UpdateMatchingStatusDto params);

	public void deleteMatchingStatusInfo(Long id);
}

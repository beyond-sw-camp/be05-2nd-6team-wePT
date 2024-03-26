package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;

public interface MatchingService {

	public void insertMatchingInfo(RequestInsertMatchingDto params);

	public Optional<ResponseMatchingDto> findMatchingInfo(Long id);

	public List<ResponseMatchingDto> findMatchingInfoList();

	public void updateMatchingInfoById(Long id, UpdateMatchingDto params);

	public void deleteMatchingInfo(Long id);

	public List<ResponseClosedMatchingDto> findClosedMatchingInfo();
}

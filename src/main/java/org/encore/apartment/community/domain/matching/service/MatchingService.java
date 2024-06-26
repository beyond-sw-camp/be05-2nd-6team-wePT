package org.encore.apartment.community.domain.matching.service;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.RequestUpdateMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;

public interface MatchingService {
	public void insertMatchingInfo(RequestInsertMatchingDto params);

	public ResponseMatchingDto findMatchingInfo(Long id);

	public List<ResponseMatchingDto> findMatchingInfoList();

	public void updateMatchingInfoById(Long id, RequestUpdateMatchingDto params);

	public void deleteMatchingInfo(Long id);

	public ResponseClosedMatchingDto findClosedMatchingInfo(Long id);
}

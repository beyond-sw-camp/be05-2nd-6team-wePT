package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;


import org.encore.apartment.community.domain.matching.data.dto.*;

public interface MatchingService {

	public void insertMatchingInfo(RequestInsertMatchingDto params);

	public Optional<ResponseMatchingDto> findMatchingInfo(Long id);

	public List<ResponseClosedMatchingDto> findClosedMatchingInfo();

	public List<ResponseMatchingDto> findMatchingInfoList();

	public void updateMatchingInfoById(Long id, UpdateMatchingDto params);

	public void deleteMatchingInfo(Long id);
}

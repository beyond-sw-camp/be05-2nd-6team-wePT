package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;


import org.encore.apartment.community.domain.matching.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;

public interface MatchingService {

	public void insertMatchingInfo(RequestMatchingDto params);

	public Optional<ResponseMatchingDto> findMatchingInfo(Long id);

	public List<ResponseMatchingDto> findMatchingInfoList();

	public void updateMatchingInfoById(Long id, UpdateMatchingDto params);

	public void deleteMatchingInfo(Long id);
}

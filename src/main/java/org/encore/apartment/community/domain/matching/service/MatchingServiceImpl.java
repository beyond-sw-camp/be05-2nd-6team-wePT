package org.encore.apartment.community.domain.matching.service;

import java.util.List;
import java.util.Optional;


import org.encore.apartment.community.domain.matching.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;
import org.encore.apartment.community.domain.matching.data.repository.MatchingRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("matching")
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

	private final MatchingRepository matchingRepository;

	@Override
	public void insertMatchingInfo(RequestMatchingDto params) {

	}

	@Override
	public Optional<ResponseMatchingDto> findMatchingInfo(Long id) {
		return Optional.empty();
	}

	@Override
	public List<ResponseMatchingDto> findMatchingInfoList() {
		return null;
	}

	@Override
	public void updateMatchingInfoById(Long id, UpdateMatchingDto params) {

	}

	@Override
	public void deleteMatchingInfo(Long id) {

	}
}

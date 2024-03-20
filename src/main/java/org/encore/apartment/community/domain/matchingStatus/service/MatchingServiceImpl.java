package org.encore.apartment.community.domain.matchingStatus.service;

import java.util.Optional;

import org.encore.apartment.community.domain.matching.data.dto.MatchingDto;
import org.encore.apartment.community.domain.matching.service.MatchingService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("matching")
@RequiredArgsConstructor
public class MatchingServiceImpl implements MatchingService {

	private final MatchingRepository matchingRepository;

	@Override
	public void createMatching(MatchingDto params) {

	}

	@Override
	public Optional<MatchingDto> readMatching(String matchingId) {
		return Optional.empty();
	}
}

package org.encore.apartment.community.domain.user.service;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.dto.MatchingDto;
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

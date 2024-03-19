package org.encore.apartment.community.domain.user.service;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.dto.MatchingDto;

public interface MatchingService {

	public void createMatching(MatchingDto params);

	public Optional<MatchingDto> readMatching(String matchingId);
}

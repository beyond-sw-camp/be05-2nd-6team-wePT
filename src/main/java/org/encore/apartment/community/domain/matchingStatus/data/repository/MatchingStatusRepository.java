package org.encore.apartment.community.domain.matchingStatus.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingStatusRepository extends JpaRepository<MatchingStatus, Long> {
	public List<MatchingStatus> findAllByMatching(Matching Matching);
}

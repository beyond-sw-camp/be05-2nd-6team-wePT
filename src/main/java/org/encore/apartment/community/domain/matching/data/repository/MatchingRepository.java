package org.encore.apartment.community.domain.matching.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchingRepository extends JpaRepository<Matching, Long> {

	@Query(value = "select matching.matchingId, matching.matchingHeadCountLimit " +
		"from Matching matching ")
	List<ResponseClosedMatchingDto> findClosedMatchingInfo();
}

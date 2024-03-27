package org.encore.apartment.community.domain.matching.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MatchingRepository extends JpaRepository<Matching, Long> {
	@Query(value = "select m from Matching m")
	List<Matching> findClosedMatchingInfo();

	List<Matching> findAll();
}

package org.encore.apartment.community.domain.matching.data.repository;

import org.encore.apartment.community.domain.matching.data.entity.Matching;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingRepository extends JpaRepository<Matching, Long> {
}

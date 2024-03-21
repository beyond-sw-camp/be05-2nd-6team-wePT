package org.encore.apartment.community.domain.matchingStatus.data.repository;

import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;
import org.encore.apartment.community.domain.matchingStatus.data.entity.MatchingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingStatusRepository extends JpaRepository<MatchingStatus, Long> {
}

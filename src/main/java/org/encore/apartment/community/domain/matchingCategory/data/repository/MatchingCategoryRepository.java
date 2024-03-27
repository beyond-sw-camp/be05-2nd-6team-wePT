package org.encore.apartment.community.domain.matchingCategory.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.encore.apartment.community.domain.matchingCategory.data.entity.MatchingCategory;

public interface MatchingCategoryRepository extends JpaRepository<MatchingCategory, Long> {
}

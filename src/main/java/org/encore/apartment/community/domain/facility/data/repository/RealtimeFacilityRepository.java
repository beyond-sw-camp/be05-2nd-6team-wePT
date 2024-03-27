package org.encore.apartment.community.domain.facility.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.entity.RealtimeFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtimeFacilityRepository extends JpaRepository<RealtimeFacility, Integer> {
	List<RealtimeFacility> findAllByRealtimeFacilityId(Integer realtimeFacilityId);

	RealtimeFacility findByRealtimeFacilityId(Integer realtimeFacilityId);
}

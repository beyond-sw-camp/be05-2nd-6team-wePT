package org.encore.apartment.community.domain.facility.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
	List<Log> findAllByLogFacilityId(Integer facilityId);

	List<Log> findAllByLogUserId(String userId);
}
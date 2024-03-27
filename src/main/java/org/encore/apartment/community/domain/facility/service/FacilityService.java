package org.encore.apartment.community.domain.facility.service;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;

public interface FacilityService {
	void createFacility(FacilityDto params);

	List<FacilityDto> readAllFacility();
}

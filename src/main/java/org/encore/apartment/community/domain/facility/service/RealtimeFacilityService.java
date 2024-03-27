package org.encore.apartment.community.domain.facility.service;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;

public interface RealtimeFacilityService {

	/*전체 시설의 사용자 수 조회*/
	List<RealtimeFacilityDto> userCnt();

	/*특정 시설의 사용자 수 조회*/
	RealtimeFacilityDto userCntFacilityId(Integer facilityId);

	/*사용자 수 업데이트 (특정 시설)*/
	void updateUserCnt(Integer facilityId);

	/*사용자 수 업데이트 (전체 시설)*/
	void updateUserCntAll();
}
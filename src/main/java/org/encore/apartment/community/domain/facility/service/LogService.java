package org.encore.apartment.community.domain.facility.service;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.LogDto;

public interface LogService {
	/*추가 (exit_time = null) -> userID & facilityID 필요*/
	void addLog(Integer facilityId, String userId);

	/*조회 (전체 확인용)*/
	List<LogDto> readAllLog();

	/*시설 아이디로 조회 (들어가 있는 사람 조회)(exit_time = null)*/
	List<LogDto> readAllByFacilityUsers(Integer facilityId);

	/*사용자 아이디로 조회 (exit_time = null)*/
	List<LogDto> readAllByUsers(String userId);

	/*수정 : 사용자가 나가는 경우 (exit_time = sysdate) facility_id*/
	void updateUserExit(String userId);
}

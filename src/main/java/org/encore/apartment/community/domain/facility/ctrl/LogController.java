package org.encore.apartment.community.domain.facility.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.LogDto;
import org.encore.apartment.community.domain.facility.service.LogService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;

@RestController
@RequestMapping("/log")
public class LogController {

	@Resource(name = "log")
	private LogService service;

	/*(exit_time = null) -> userID & facilityID 필요*/
	@Operation(summary = "로그 추가")
	@PostMapping(value = "/entry/{facilityId}/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<?> createReservation(@PathVariable("facilityId") String facilityId,
		@PathVariable("userId") String userId) {
		service.addLog(Integer.parseInt(facilityId), userId);

		return ApiResponse.createSuccessWithNoContent();
	}

	@Operation(summary = "로그 정보 조회(전체 확인용)")
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<LogDto>> readAllLog() {
		List<LogDto> list = service.readAllLog();

		return ApiResponse.createSuccess(list);
	}

	/*(들어가 있는 사람 조회)(exit_time = null)*/
	@Operation(summary = "시설별(시설 아이디) 로그 정보 조회")
	@GetMapping(value = "/info-facility/{facilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<LogDto>> readAllByFacilityId(@PathVariable("facilityId") String facilityId) {
		List<LogDto> list = service.readAllByFacilityUsers(Integer.parseInt(facilityId));

		return ApiResponse.createSuccess(list);
	}

	//(exit_time = null) 만약 dto가 1개 이상 출력되면 오류(중복 입장)
	@Operation(summary = "사용자별(사용자 아이디) 로그 정보 조회")
	@GetMapping(value = "/info-user/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<LogDto>> readAllByUsers(@PathVariable("userId") String userId) {
		List<LogDto> list = service.readAllByUsers(userId);

		return ApiResponse.createSuccess(list);
	}

	//(exit_time = sysdate) facility_id
	@Operation(summary = "로그 수정")
	@PostMapping(value = "/out/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<?> updateUserNums(@PathVariable("userId") String userId) {
		service.updateUserExit(userId);

		return ApiResponse.createSuccessWithNoContent();
	}
}

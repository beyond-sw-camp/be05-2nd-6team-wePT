package org.encore.apartment.community.domain.facility.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.RealtimeFacilityDto;
import org.encore.apartment.community.domain.facility.service.RealtimeFacilityService;
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
@RequestMapping("/realtimefacility")
public class RealtimeFacilityController {

	@Resource(name = "realtimefacility")
	private RealtimeFacilityService service;

	@Operation(summary = "전체 시설 사용자 수 조회")    // 기본은 다 0으로 넣어주기
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<RealtimeFacilityDto>> userCnt() {
		List<RealtimeFacilityDto> list = service.userCnt();
		return ApiResponse.createSuccess(list);
	}

	@Operation(summary = "특정 시설 사용자 수 조회")
	@GetMapping(value = "/info/{facilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<RealtimeFacilityDto> userCnt(@PathVariable("facilityId") String facilityId) {
		RealtimeFacilityDto dto = service.userCntFacilityId(Integer.parseInt(facilityId));
		return ApiResponse.createSuccess(dto);
	}

	@Operation(summary = "사용자수 업데이트 (특정 시설)")
	@PostMapping(value = "/update/{realtimeFacilityId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<?> updateByFacilityId(@PathVariable("realtimeFacilityId") String realtimeFacilityId) {
		service.updateUserCnt(Integer.parseInt(realtimeFacilityId));
		return ApiResponse.createSuccessWithNoContent();
	}

	@Operation(summary = "사용자수 업데이트 (전체 시설)")
	@PostMapping(value = "/update-all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<?> updateAll() {
		service.updateUserCntAll();
		return ApiResponse.createSuccessWithNoContent();
	}
}

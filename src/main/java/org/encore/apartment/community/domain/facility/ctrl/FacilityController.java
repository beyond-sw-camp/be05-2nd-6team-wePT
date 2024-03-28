package org.encore.apartment.community.domain.facility.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.facility.service.FacilityService;
import org.encore.apartment.community.global.annotation.AdminAuthorize;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/facility")
public class FacilityController {

	@Resource(name = "facility")
	private FacilityService service;

	// TODO: 혹시 몰라 생성
	@Operation(summary = "시설 등록")
	@AdminAuthorize
	@PostMapping(value = "/add-facility", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<?> createFacility(@Valid @RequestBody FacilityDto params) {
		service.createFacility(params);

		return ApiResponse.createSuccessWithNoContent();
	}

	@Operation(summary = "시설 정보 조회")
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<FacilityDto>> readAllFacility() {
		List<FacilityDto> list = service.readAllFacility();
		return ApiResponse.createSuccess(list);
	}
}
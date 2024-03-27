package org.encore.apartment.community.domain.matching.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.RequestUpdateMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.service.MatchingService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/matching")
public class MatchingController {

	@Resource(name = "matching")
	private MatchingService service;

	@Operation(summary = "사용자가 매칭을 새로 생성할 경우 매칭정보 테이블에 매칭정보 등록")
	@PostMapping("/insert")
	public ApiResponse<?> insertMatchingInfo(@Valid @RequestBody RequestInsertMatchingDto params) {
		service.insertMatchingInfo(params);
		log.info("MatchingController insertMatchingInfo = {}", params);

		return ApiResponse.createSuccessWithNoContent();
	}

	// @Operation(summary = "매칭정보 등록")
	// @PostMapping("/insert")
	// public ApiResponse<?> insertMatchingInfo(@RequestBody RequestInsertMatchingDto params) {
	// 	service.insertMatchingInfo(params);
	// 	log.info("MatchingController insertMatchingInfo = {}", params);
	//
	// 	return ApiResponse.createSuccessWithNoContent();
	// }

	@Operation(summary = "매칭id로 해당 매칭정보 확인")
	@GetMapping("/find/{id}")
	public ApiResponse<ResponseMatchingDto> findMatchingInfo(@PathVariable(value = "id") Long id) {
		ResponseMatchingDto dto = service.findMatchingInfo(id);
		log.info("MatchingController findMatchingInfo = {}", dto);

		return ApiResponse.createSuccess(dto);
	}

	// @Operation(summary = " 매칭정보 테이블 내 매칭정보 일괄확인")
	// @GetMapping("/list")
	// public ResponseEntity<List<ResponseMatchingDto>> findMatchingInfoList() {
	// 	List<ResponseMatchingDto> dto = service.findMatchingInfoList();
	// 	log.info("MatchingController findMatchingInfoList = {}", dto);
	//
	// 	return new ResponseEntity<List<ResponseMatchingDto>>(dto, HttpStatus.OK);
	// }

	@Operation(summary = " 매칭정보 테이블 내 매칭정보 일괄확인")
	@GetMapping("/list")
	public ApiResponse<List<ResponseMatchingDto>> findMatchingInfoList() {
		List<ResponseMatchingDto> dto = service.findMatchingInfoList();
		log.info("MatchingController findMatchingInfoList = {}", dto);

		return ApiResponse.createSuccess(dto);
	}

	@Operation(summary = "매칭id로 해당 매칭의 매칭분류(category),매칭모집원인 수정")
	@PostMapping("/update/{id}")
	public ApiResponse<?> updateMatchingInfo(@PathVariable(value = "id") Long id,
		@RequestBody RequestUpdateMatchingDto params) {
		log.info("MatchingController updateMatchingInfo = {}", params);
		service.updateMatchingInfoById(id, params);

		return ApiResponse.createSuccessWithNoContent();
	}

	@Operation(summary = "매칭id로 해당매칭정보 삭제")
	@DeleteMapping("/delete/{id}")
	public ApiResponse<?> deleteMatchingInfo(@PathVariable(value = "id") Long id) {
		log.info("MatchingController deleteMatchingInfo = {}", id);
		System.out.println("DEBUG MatchingController::deleteMatchingInfo");
		service.deleteMatchingInfo(id);

		return ApiResponse.createSuccessWithNoContent();
	}

	// @Operation(summary = "매칭id로 해당매칭정보 삭제")
	// @DeleteMapping("/delete/{id}")
	// public ResponseEntity<Void> deleteMatchingInfo(@PathVariable(value = "id") Long id) {
	// 	log.info("MatchingController deleteMatchingInfo = {}", id);
	// 	System.out.println("DEBUG MatchingController::deleteMatchingInfo");
	// 	service.deleteMatchingInfo(id);
	//
	// 	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	// }

	@Operation(summary = "매칭id로 매칭아이디, 매칭의 인원제한, 참여인원 수를 검색 후 리턴받아 해당 매칭의 마감여부 확인 ")
	@GetMapping("/find/closed/{id}")
	public ApiResponse<ResponseClosedMatchingDto> findClosedMatchingInfo(@PathVariable(value = "id") Long id) {
		ResponseClosedMatchingDto dto = service.findClosedMatchingInfo(id);
		log.info("MatchingController findClosedMatchingStatusInfoList = {}", dto);

		return ApiResponse.createSuccess(dto);

	}

	// @Operation(summary = "매칭id로 매칭아이디, 매칭의 인원제한, 참여인원 수를 검색 후 리턴받아 해당 매칭의 마감여부 확인 ")
	// @GetMapping("/find/closed/{id}")
	// public ResponseEntity<ResponseClosedMatchingDto> findClosedMatchingInfo(@PathVariable(value = "id") Long id) {
	// 	ResponseClosedMatchingDto dto = service.findClosedMatchingInfo(id);
	// 	log.info("MatchingController findClosedMatchingStatusInfoList = {}", dto);
	//
	// 	return new ResponseEntity<ResponseClosedMatchingDto>(dto, HttpStatus.OK);
	//
	// }
}



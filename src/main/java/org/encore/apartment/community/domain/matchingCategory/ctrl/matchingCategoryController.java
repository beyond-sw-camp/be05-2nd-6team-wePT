package org.encore.apartment.community.domain.matchingCategory.ctrl;

import org.encore.apartment.community.domain.matchingCategory.data.dto.RequestInsertMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.service.MatchingCategoryService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/matchingCategory")
public class matchingCategoryController {

	@Resource(name = "matchingCategory")
	private MatchingCategoryService service;

	@Operation(summary = "매칭분류(category) 추가")
	@PostMapping("/insert")
	public ApiResponse<?> insertMatchingCategoryInfo(@RequestBody RequestInsertMatchingCategoryDto params) {
		service.insertMatchingCategoryInfo(params);
		log.info("MatchingCategoryController insertMatchingCategoryInfo = {}", params);

		return ApiResponse.createSuccessWithNoContent();
	}

	/*
	* @Operation(summary = "매칭분류(category) 추가")
	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingCategoryInfo(@RequestBody RequestInsertMatchingCategoryDto params) {
		service.insertMatchingCategoryInfo(params);
		log.info("MatchingCategoryController insertMatchingCategoryInfo = {}", params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseMatchingCategoryDto>> findMatchingCategoryInfo(@PathVariable Long id) {
		Optional<ResponseMatchingCategoryDto> dto = service.findMatchingCategoryInfo(id);
		log.info("MatchingCategoryController findMatchingCategoryInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseMatchingCategoryDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ResponseMatchingCategoryDto>> findMatchingCategoryInfoList() {
		List<ResponseMatchingCategoryDto> dto = service.findMatchingCategoryInfoList();
		log.info("MatchingCategoryController findMatchingCategoryInfoList = {}", dto);

		return new ResponseEntity<List<ResponseMatchingCategoryDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateMatchingCategoryInfo(@PathVariable("id") Long id,
		@RequestBody UpdateMatchingCategoryDto params) {
		log.info("MatchingCategoryController updateMatchingCategoryInfo = {}", params);
		service.updateMatchingCategoryInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMatchingCategoryInfo(@PathVariable Long id) {
		log.info("MatchingCategoryController deleteMatchingCategoryInfo = {}", id);
		service.deleteMatchingCategoryInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	* */

}

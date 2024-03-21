package org.encore.apartment.community.domain.matchingCategory.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matchingCategory.data.dto.RequestMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.ResponseMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.data.dto.UpdateMatchingCategoryDto;
import org.encore.apartment.community.domain.matchingCategory.service.MatchingCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/matchingCategory")
public class matchingCategoryController {

	@Resource(name = "apartment")
	private MatchingCategoryService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingCategoryInfo(@RequestBody RequestMatchingCategoryDto params) {
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
}

package org.encore.apartment.community.domain.matching.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matching.data.dto.RequestInsertMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseClosedMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;
import org.encore.apartment.community.domain.matching.service.MatchingService;
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
@RequestMapping("/api/matching")
public class MatchingController {

	@Resource(name = "matching")
	private MatchingService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingInfo(@RequestBody RequestInsertMatchingDto params) {
		service.insertMatchingInfo(params);
		log.info("MatchingController insertMatchingInfo = {}", params);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseMatchingDto>> findMatchingInfo(@PathVariable(value = "id") Long id) {
		Optional<ResponseMatchingDto> dto = service.findMatchingInfo(id);
		log.info("MatchingController findMatchingInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseMatchingDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/find/closed")
	public ResponseEntity<List<ResponseClosedMatchingDto>> findClosedMatchingInfo() {
		List<ResponseClosedMatchingDto> dto = service.findClosedMatchingInfo();
		log.info("MatchingController findMatchingInfo = {}", dto);

		return new ResponseEntity<List<ResponseClosedMatchingDto>>(dto, HttpStatus.OK);
	}



	@GetMapping("/list")
	public ResponseEntity<List<ResponseMatchingDto>> findMatchingInfoList() {
		List<ResponseMatchingDto> dto = service.findMatchingInfoList();
		log.info("MatchingController findMatchingInfoList = {}", dto);

		return new ResponseEntity<List<ResponseMatchingDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateMatchingInfo(@PathVariable(value = "id") Long id,
		@RequestBody UpdateMatchingDto params) {
		log.info("MatchingController updateMatchingInfo = {}", params);
		service.updateMatchingInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMatchingInfo(@PathVariable(value = "id") Long id) {
		log.info("MatchingController deleteMatchingInfo = {}", id);
		service.deleteMatchingInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



package org.encore.apartment.community.domain.matching.ctrl;

import jakarta.annotation.Resource;


import org.encore.apartment.community.domain.apartment.data.dto.ResponseApartmentDto;
import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;
import org.encore.apartment.community.domain.matching.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.ResponseMatchingDto;
import org.encore.apartment.community.domain.matching.data.dto.UpdateMatchingDto;
import org.encore.apartment.community.domain.matching.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/matching")
public class MatchingController {

	@Resource(name = "matching")
	private MatchingService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingInfo(@RequestBody RequestMatchingDto params) {
		service.insertMatchingInfo(params);
		log.info("MatchingController insertMatchingInfo = {}", params);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseMatchingDto>> findMatchingInfo(@PathVariable Long id) {
		Optional<ResponseMatchingDto> dto = service.findMatchingInfo(id);
		log.info("MatchingController findMatchingInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseMatchingDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ResponseMatchingDto>> findMatchingInfoList() {
		List<ResponseMatchingDto> dto = service.findMatchingInfoList();
		log.info("MatchingController findMatchingInfoList = {}", dto);

		return new ResponseEntity<List<ResponseMatchingDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateMatchingInfo(@PathVariable("id") Long id, @RequestBody UpdateMatchingDto params) {
		log.info("MatchingController updateMatchingInfo = {}", params);
		service.updateMatchingInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMatchingInfo(@PathVariable Long id) {
		log.info("MatchingController deleteMatchingInfo = {}", id);
		service.deleteMatchingInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



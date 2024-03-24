package org.encore.apartment.community.domain.matchingStatus.ctrl;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestInsertMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.RequestMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.ResponseMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.data.dto.UpdateMatchingStatusDto;
import org.encore.apartment.community.domain.matchingStatus.service.MatchingStatusService;
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
@RequestMapping("/api/matchingStatus")
public class matchingStatusController {

	@Resource(name = "matchingStatus")
	private MatchingStatusService service;

	@PostMapping("/insert")
	public ResponseEntity<Void> insertMatchingStatusInfo(@RequestBody RequestInsertMatchingStatusDto params) {
		service.insertMatchingStatusInfo(params);
		log.info("MatchingStatusController insertMatchingStatusInfo = {}", params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<ResponseMatchingStatusDto>> findMatchingStatusInfo(@PathVariable Long id) {
		Optional<ResponseMatchingStatusDto> dto = service.findMatchingStatusInfo(id);
		log.info("MatchingStatusController findMatchingStatusInfo = {}", dto);

		return new ResponseEntity<Optional<ResponseMatchingStatusDto>>(dto, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<ResponseMatchingStatusDto>> findMatchingStatusInfoList() {
		List<ResponseMatchingStatusDto> dto = service.findMatchingStatusInfoList();
		log.info("MatchingStatusController findMatchingStatusInfoList = {}", dto);

		return new ResponseEntity<List<ResponseMatchingStatusDto>>(dto, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Void> updateMatchingStatusInfo(@PathVariable("id") Long id,
		@RequestBody UpdateMatchingStatusDto params) {
		log.info("MatchingStatusController updateMatchingStatusInfo = {}", params);
		service.updateMatchingStatusInfoById(id, params);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMatchingStatusInfo(@PathVariable Long id) {
		log.info("MatchingStatusController deleteMatchingStatusInfo = {}", id);
		service.deleteMatchingStatusInfo(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}



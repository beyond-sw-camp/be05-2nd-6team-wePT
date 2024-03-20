package org.encore.apartment.community.domain.matching.ctrl;

import jakarta.annotation.Resource;


import org.encore.apartment.community.domain.matching.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.matching.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

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
}



package org.encore.apartment.community.domain.user.ctrl;

import jakarta.annotation.Resource;

import org.encore.apartment.community.domain.user.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.user.service.MatchingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.responses.ApiResponse;

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



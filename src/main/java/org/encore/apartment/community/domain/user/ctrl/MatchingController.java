package org.encore.apartment.community.domain.user.ctrl;

import org.encore.apartment.community.domain.user.data.dto.MatchingDto;
import org.encore.apartment.community.domain.user.service.MatchingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.models.responses.ApiResponse;
import jakarta.annotation.Resources;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/matching")
public class MatchingController {

	@Resources(name = "matching")
	private MatchingService service;

	@PostMapping("/insert")
	public ApiResponse<Void> insertMatchingInfo(@RequestBody MatchingDto params) {

	}
}



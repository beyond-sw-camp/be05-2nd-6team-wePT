package org.encore.apartment.community.domain.user.ctrl;

import org.encore.apartment.community.domain.user.service.MatchingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resources;

@RestController
@RequestMapping("/api/matching")
public class MatchingController {

	@Resources(name = "matching")
	private MatchingService matchingService;
}



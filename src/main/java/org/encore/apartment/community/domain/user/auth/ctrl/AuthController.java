package org.encore.apartment.community.domain.user.auth.ctrl;

import org.encore.apartment.community.domain.user.auth.dto.SignInRequestDto;
import org.encore.apartment.community.domain.user.auth.dto.SignInResponseDto;
import org.encore.apartment.community.domain.user.auth.service.AuthService;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserResponseDto;
import org.encore.apartment.community.domain.user.info.service.UserService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {

	private final AuthService authService;

	private final UserService userService;

	@Operation(summary = "로그인")
	@PostMapping("/sign-in")
	public ApiResponse<SignInResponseDto> signIn(@RequestBody SignInRequestDto params) {
		log.debug("==== AuthController signIn() params: {}", params);
		return ApiResponse.createSuccess(authService.signIn(params));
	}
}

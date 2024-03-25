package org.encore.apartment.community.domain.user.info.ctrl;

import java.util.Map;

import org.encore.apartment.community.domain.user.info.data.dto.user.UserRequestDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserResponseDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserUpdateRequestDto;
import org.encore.apartment.community.domain.user.info.service.UserService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource(name = "user")
	private UserService service;

	@Operation(summary = "회원 가입")
	@PostMapping(value = "/sign-up", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Map<String, Long>> createUser(@RequestBody UserRequestDto params) {
		Long idx = service.createUser(params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}

	@Operation(summary = "회원 정보 조회")
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<UserResponseDto> getUserInfo(@RequestParam Long idx, @RequestParam String id) {
		log.info("getUserInfo = {} {}", idx, id);
		UserResponseDto user = service.findUserInfo(idx);

		return ApiResponse.createSuccess(user);
	}

	@Operation(summary = "회원 정보 수정")
	@PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Map<String, Long>> updateUserInfo(@RequestBody UserUpdateRequestDto params) {
		Long idx = service.updateUserInfo(params);
		Map<String, Long> map = Map.of("userIdx", idx);

		return ApiResponse.createSuccess(map);
	}

	@Operation(summary = "회원 삭제")
	@DeleteMapping("/delete")
	public ApiResponse<Map<String, Long>> deleteUser(@RequestParam Long idx) {
		Long userIdx = service.deleteUser(idx);
		Map<String, Long> map = Map.of("userIdx", userIdx);

		return ApiResponse.createSuccess(map);
	}
}

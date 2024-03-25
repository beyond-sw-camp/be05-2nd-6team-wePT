package org.encore.apartment.community.domain.user.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInResponseDto(
	@Schema(description = "회원 고유 키", example = "1")
	Long userIdx,
	@Schema(description = "회원 아이디", example = "xlyeon12")
	String userId
) {
}

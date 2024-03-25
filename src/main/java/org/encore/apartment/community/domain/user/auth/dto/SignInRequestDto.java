package org.encore.apartment.community.domain.user.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record SignInRequestDto(
	@Schema(description = "회원 아이디", example = "xlyeon12")
	String userId,
	@Schema(description = "회원 비밀번호", example = "qwer1234")
	String userPassword
) {
}

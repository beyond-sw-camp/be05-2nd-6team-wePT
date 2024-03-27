package org.encore.apartment.community.domain.user.service;

import org.encore.apartment.community.domain.user.data.dto.UserRequestDto;
import org.encore.apartment.community.domain.user.data.dto.UserResponseDto;
import org.encore.apartment.community.domain.user.data.dto.UserUpdateRequestDto;

public interface UserService {
	Long createUser(UserRequestDto params);

	UserResponseDto findUserInfo(String userId);

	Long updateUserInfo(String userId, UserUpdateRequestDto params);

	Long deleteUser(Long idx);
}

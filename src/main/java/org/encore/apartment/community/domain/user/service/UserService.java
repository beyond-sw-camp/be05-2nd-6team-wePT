package org.encore.apartment.community.domain.user.service;

import org.encore.apartment.community.domain.user.data.dto.UserRequestDto;
import org.encore.apartment.community.domain.user.data.dto.UserResponseDto;
import org.encore.apartment.community.domain.user.data.dto.UserUpdateRequestDto;

public interface UserService {
	public Long createUser(UserRequestDto params);

	public UserResponseDto findUserInfo(Long idx);

	public Long updateUserInfo(UserUpdateRequestDto params);

	public Long deleteUser(Long idx);
}

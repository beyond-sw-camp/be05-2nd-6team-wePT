package org.encore.apartment.community.domain.user.info.service;

import org.encore.apartment.community.domain.user.info.data.dto.user.UserRequestDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserResponseDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserUpdateRequestDto;

public interface UserService {
	public Long createUser(UserRequestDto params);

	public UserResponseDto findUserInfo(Long idx);

	public Long updateUserInfo(UserUpdateRequestDto params);

	public Long deleteUser(Long idx);
}

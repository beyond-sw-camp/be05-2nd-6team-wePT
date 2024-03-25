package org.encore.apartment.community.domain.user.info.service;

import org.encore.apartment.community.domain.user.info.data.dto.user.RequestUserDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.ResponseUserDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UpdateRequestUserDto;

public interface UserService {
	public Long createUser(RequestUserDto params);

	public ResponseUserDto findUserInfo(Long idx);

	public Long updateUserInfo(UpdateRequestUserDto params);

	public Long deleteUser(Long idx);
}

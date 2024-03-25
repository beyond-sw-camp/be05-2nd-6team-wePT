package org.encore.apartment.community.domain.user.info.service;

import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.repository.ApartmentRepository;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserRequestDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserResponseDto;
import org.encore.apartment.community.domain.user.info.data.dto.user.UserUpdateRequestDto;
import org.encore.apartment.community.domain.user.info.data.entity.User;
import org.encore.apartment.community.domain.user.info.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("user")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final ApartmentRepository apartmentRepository;

	private final PasswordEncoder encoder;

	@Override
	@Transactional
	public Long createUser(UserRequestDto params) {
		User user = UserRequestDto.toEntity(params, encoder);
		apartmentRepository.findById(params.getApartmentId()).ifPresent(user::setApartment);
		log.info("createUser = {}", user);

		return userRepository.save(user).getUserIdx();
	}

	@Override
	public UserResponseDto findUserInfo(Long idx) {
		Optional<User> user = userRepository.findById(idx);
		UserResponseDto userResponseDto = new UserResponseDto(user.get());
		userResponseDto.setApartmentInfo(user.get().getApartment());
		log.info("findUserInfo = {}", user);

		return userResponseDto;
	}

	@Override
	public Long updateUserInfo(UserUpdateRequestDto params) {
		Optional<User> user = userRepository.findById(params.getUserIdx());
		user.ifPresent(u -> u.update(params));
		log.info("updateUserInfo = {}", user);
		userRepository.save(user.get());

		return user.get().getUserIdx();
	}

	@Override
	public Long deleteUser(Long idx) {
		Optional<User> user = userRepository.findById(idx);
		user.get().updateDeleteYn();
		userRepository.save(user.get());

		return user.get().getUserIdx();
	}
}

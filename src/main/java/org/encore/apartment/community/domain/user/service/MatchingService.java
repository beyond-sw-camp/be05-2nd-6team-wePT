package org.encore.apartment.community.domain.user.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.dto.UpdateApartmentDto;
import org.encore.apartment.community.domain.user.data.dto.MatchingDto;
import org.encore.apartment.community.domain.user.data.dto.RequestMatchingDto;
import org.encore.apartment.community.domain.user.data.dto.ResponseMatchingDto;

import io.swagger.v3.oas.models.responses.ApiResponse;

public interface MatchingService {

	public void insertMatchingInfo(RequestMatchingDto params);

	public Optional<ResponseMatchingDto> findMatchingInfo(Long id);

	public List<ResponseMatchingDto> findMatchingInfoList();

	public void updateMatchingInfoById(Long id, UpdateMatchingDto params)

	public void deleteMatchingInfo(Long id);
}

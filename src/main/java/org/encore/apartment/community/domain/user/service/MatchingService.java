package org.encore.apartment.community.domain.user.service;

import java.util.List;
import java.util.Optional;

import org.encore.apartment.community.domain.user.data.dto.MatchingDto;
import org.encore.apartment.community.domain.user.data.dto.RequestMatchingDto;

import io.swagger.v3.oas.models.responses.ApiResponse;

public interface MatchingService {

	public void insertMatchingInfo(RequestMatchingDto params);

	public Optional<ApiResponse> findApartmentInfo(Long id);

	public List<ApiResponse>
}

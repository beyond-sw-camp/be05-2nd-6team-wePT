package org.encore.apartment.community.domain.facility.ctrl;


import jakarta.annotation.Resource;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;
import org.encore.apartment.community.domain.facility.service.ReservationService;
import org.springframework.http.MediaType;

import java.util.List;

import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Resource(name = "reservation")
	private ReservationService service;

	@Operation(summary = "예약 추가")
	@PostMapping(value = "/add-reservation", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<ReservationDto> createReservation(@Valid @RequestBody ReservationDto params) {
		service.createReservation(params);

		return ApiResponse.createSuccess(params);
	}

	@Operation(summary = "예약 정보 조회")
	@GetMapping(value = "/info", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<ReservationDto>> readAllReservation() {
		List<ReservationDto> list = service.readAllReservation();

		return ApiResponse.createSuccess(list);
	}

	@Operation(summary = "본인 예약 정보 조회")
	@GetMapping(value = "/myinfo/{reservationUserId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<List<ReservationDto>> readMyReservation(
		@PathVariable("reservationUserId") String reservationUserId) {
		List<ReservationDto> list = service.readMyReservation(reservationUserId);

		return ApiResponse.createSuccess(list);
	}

	@Operation(summary = "예약 삭제")
	@PostMapping(value = "/delete/{reservationUserId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ApiResponse<Void> deleteMyReservation(@PathVariable("reservationUserId") String reservationUserId) {
		service.deleteReservation(reservationUserId);

		return ApiResponse.createSuccess(null);
	}

}

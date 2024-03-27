package org.encore.apartment.community.domain.facility.service;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.RequestReservationDto;
import org.encore.apartment.community.domain.facility.data.dto.ReservationDto;

public interface ReservationService {

	/*예약서 작성 (예약 추가)*/
	void createReservation(RequestReservationDto params);

	/*전체 예약목록 확인*/
	List<ReservationDto> readAllReservation();

	/*예약서 조회(본인의 갓만 확인 가능)*/
	List<ReservationDto> readMyReservation(String reservationUserId);

	/*본인 에약목록 삭제 (deleteYn update)*/
	void deleteReservation(String reservationUserId);
}

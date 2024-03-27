package org.encore.apartment.community.domain.facility.data.dto;

import java.util.Date;

import org.encore.apartment.community.domain.facility.data.entity.Reservation;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationDto {
	@NotNull
	private Integer reservationId;

	@NotNull
	private String reservationUserId;

	@NotNull
	private Integer reservationFacilityId;

	@NotNull
	private Date reservationStartTime;

	@NotNull
	private Date reservationEndTime;

	@NotNull
	private Integer reservationHeadcount;

	@Builder
	public static Reservation toEntity(ReservationDto reservationDto) {
		return Reservation.builder()
			.reservationId(reservationDto.getReservationId())
			.reservationUserId(reservationDto.getReservationUserId())
			.reservationFacilityId(reservationDto.getReservationFacilityId())
			.reservationStartTime(reservationDto.getReservationStartTime())
			.reservationEndTime(reservationDto.getReservationEndTime())
			.reservationHeadcount(reservationDto.getReservationHeadcount())
			.deleteYn(false)
			.build();
	}

	@Builder
	public ReservationDto(Reservation reservation) {
		this.reservationId = reservation.getReservationId();
		this.reservationUserId = reservation.getReservationUserId();
		this.reservationFacilityId = reservation.getReservationFacilityId();
		this.reservationStartTime = reservation.getReservationStartTime();
		this.reservationEndTime = reservation.getReservationEndTime();
		this.reservationHeadcount = reservation.getReservationHeadcount();
	}
}



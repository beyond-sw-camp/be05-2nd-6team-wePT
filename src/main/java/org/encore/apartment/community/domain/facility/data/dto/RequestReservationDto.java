package org.encore.apartment.community.domain.facility.data.dto;

import java.util.Date;

import org.encore.apartment.community.domain.facility.data.entity.Reservation;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestReservationDto {
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

    public static Reservation toEntity(RequestReservationDto requestReservationDto) {
        return Reservation.builder()
                .reservationUserId(requestReservationDto.getReservationUserId())
                .reservationFacilityId(requestReservationDto.getReservationFacilityId())
                .reservationStartTime(requestReservationDto.getReservationStartTime())
                .reservationEndTime(requestReservationDto.getReservationEndTime())
                .reservationHeadcount(requestReservationDto.getReservationHeadcount())
                .build();
    }


}

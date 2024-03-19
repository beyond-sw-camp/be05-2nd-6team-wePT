package org.encore.apartment.community.domain.facility.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.encore.apartment.community.domain.facility.data.entity.Facility;

@Getter
@Setter
public class FacilityDto {
    @NotNull
    private String facilityId;

    @NotNull
    private String facilityName;

    @NotNull
    private Integer facilityOperatingTime;

    @NotNull
    private String facilityMembershipYn;

    @NotNull
    private Integer facilityFee;

    private Integer facilityReservationAvailbleTime;

    public static Facility toEntity(FacilityDto userDto) {
        return Facility.builder()
                .facilityId(userDto.getFacilityId())
                .facilityName(userDto.getFacilityName())
                .facilityOperatingTime(userDto.getFacilityOperatingTime())
                .facilityMembershipYn(userDto.getFacilityMembershipYn())
                .facilityFee(userDto.getFacilityFee())
                .facilityReservationAvailbleTime(userDto.getFacilityReservationAvailbleTime())
                .build();
    }
}

/*
facility_id (String)
facility_name
facility_operating_time
facility_membership_yn
facility_fee
facility_reservation_availble_time
 */
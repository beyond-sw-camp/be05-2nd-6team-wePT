package org.encore.apartment.community.domain.facility.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Facility {

    @Id
    @Column(name = "facility_id")
    private String facilityId;

    @NotNull
    @Column(name = "facility_name")
    private String facilityName;

    @NotNull
    @Column(name = "facility_operating_time")
    private Integer facilityOperatingTime;

    @NotNull
    @Column(name = "facility_membership_yn")
    private String facilityMembershipYn;

    @NotNull
    @Column(name = "facility_fee")
    private Integer facilityFee;

    @Column(name = "facility_reservation_availble_time")
    private Integer facilityReservationAvailbleTime;

    @Builder
    public Facility(
            String facilityId,
            String facilityName,
            Integer facilityOperatingTime,
            String facilityMembershipYn,
            Integer facilityFee,
            Integer facilityReservationAvailbleTime
    ){
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityOperatingTime = facilityOperatingTime;
        this.facilityMembershipYn = facilityMembershipYn;
        this.facilityFee = facilityFee;
        this.facilityReservationAvailbleTime = facilityReservationAvailbleTime;
    }
}

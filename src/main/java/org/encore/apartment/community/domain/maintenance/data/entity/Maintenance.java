package org.encore.apartment.community.domain.maintenance.data.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maintenance_idx")
    private Long maintenanceIdx;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "user_idx", nullable = false)
    private Long userIdx;

    @Column(name = "general_maintenance_fee", nullable = false)
    private Integer generalMaintenanceFee;

    @Column(name = "security_service_fee", nullable = false)
    private Integer securityServiceFee;

    @Column(name = "disinfection_fee", nullable = false)
    private Integer disinfectionFee;

    @Column(name = "elevator_maintenance_fee", nullable = false)
    private Integer elevatorMaintenanceFee;

    @Column(name = "intelligent_maintenance_fee", nullable = false)
    private Integer intelligentMaintenanceFee;

    @Column(name = "heating_maintenance_fee", nullable = false)
    private Integer heatingMaintenanceFee;

    @Column(name = "hot_water_supply_fee", nullable = false)
    private Integer hotWaterSupplyFee;

    @Column(name = "repair_fee", nullable = false)
    private Integer repairFee;

    @Column(name = "entrusted_management_fee", nullable = false)
    private Integer entrustedManagementFee;

    @Column(name = "cleaning_fee", nullable = false)
    private Integer cleaningFee;

    @Column(name = "membership_fee", nullable = false)
    private Integer membershipFee;

    @Builder
    public Maintenance(Date paymentDate, Long userIdx, Integer generalMaintenanceFee, Integer securityServiceFee,
                          Integer disinfectionFee, Integer elevatorMaintenanceFee, Integer intelligentMaintenanceFee,
                          Integer heatingMaintenanceFee, Integer hotWaterSupplyFee, Integer repairFee, Integer entrustedManagementFee,
                          Integer cleaningFee, Integer membershipFee) {
        this.paymentDate = paymentDate;
        this.userIdx = userIdx;
        this.generalMaintenanceFee = generalMaintenanceFee;
        this.securityServiceFee = securityServiceFee;
        this.disinfectionFee = disinfectionFee;
        this.elevatorMaintenanceFee = elevatorMaintenanceFee;
        this.intelligentMaintenanceFee = intelligentMaintenanceFee;
        this.heatingMaintenanceFee = heatingMaintenanceFee;
        this.hotWaterSupplyFee = hotWaterSupplyFee;
        this.repairFee = repairFee;
        this.entrustedManagementFee = entrustedManagementFee;
        this.cleaningFee = cleaningFee;
        this.membershipFee = membershipFee;
    }

}

/*
maintenance_idx
payment_date
user_idx
general_maintenance_fee
security_service_fee
disinfection_fee
elevator_maintenance_fee
intelligent_maintenance_fee
heating_maintenance_fee
hot_water_supply_fee
repair_fee
entrusted_management_fee
cleaning_fee
membership_fee

 */
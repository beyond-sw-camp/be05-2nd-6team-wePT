package org.encore.apartment.community.domain.maintenance.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.encore.apartment.community.domain.maintenance.data.entity.Maintenance;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MaintenanceDto {
    @NotNull
    private Date paymentDate;
    @NotNull
    private Long userIdx;
    @NotNull
    private Integer generalMaintenanceFee;
    @NotNull
    private Integer securityServiceFee;
    @NotNull
    private Integer disinfectionFee;
    @NotNull
    private Integer elevatorMaintenanceFee;
    @NotNull
    private Integer intelligentMaintenanceFee;
    @NotNull
    private Integer heatingMaintenanceFee;
    @NotNull
    private Integer hotWaterSupplyFee;
    @NotNull
    private Integer repairFee;
    @NotNull
    private Integer entrustedManagementFee;
    @NotNull
    private Integer cleaningFee;
    @NotNull
    private Integer membershipFee;

    public static Maintenance toEntity(MaintenanceDto maintenanceDto) {
        return Maintenance.builder()
                .paymentDate(maintenanceDto.getPaymentDate())
                .userIdx(maintenanceDto.getUserIdx())
                .generalMaintenanceFee(maintenanceDto.getGeneralMaintenanceFee())
                .securityServiceFee(maintenanceDto.getSecurityServiceFee())
                .disinfectionFee(maintenanceDto.getDisinfectionFee())
                .elevatorMaintenanceFee(maintenanceDto.getElevatorMaintenanceFee())
                .intelligentMaintenanceFee(maintenanceDto.getIntelligentMaintenanceFee())
                .heatingMaintenanceFee(maintenanceDto.getHeatingMaintenanceFee())
                .hotWaterSupplyFee(maintenanceDto.getHotWaterSupplyFee())
                .repairFee(maintenanceDto.getRepairFee())
                .entrustedManagementFee(maintenanceDto.getEntrustedManagementFee())
                .cleaningFee(maintenanceDto.getCleaningFee())
                .membershipFee(maintenanceDto.getMembershipFee())
                .build();
    }

    public MaintenanceDto(Maintenance maintenance) {
        this.paymentDate = maintenance.getPaymentDate();
        this.userIdx = maintenance.getUserIdx();
        this.generalMaintenanceFee = maintenance.getGeneralMaintenanceFee();
        this.securityServiceFee = maintenance.getSecurityServiceFee();
        this.disinfectionFee = maintenance.getDisinfectionFee();
        this.elevatorMaintenanceFee = maintenance.getElevatorMaintenanceFee();
        this.intelligentMaintenanceFee = maintenance.getIntelligentMaintenanceFee();
        this.heatingMaintenanceFee = maintenance.getHeatingMaintenanceFee();
        this.hotWaterSupplyFee = maintenance.getHotWaterSupplyFee();
        this.repairFee = maintenance.getRepairFee();
        this.entrustedManagementFee = maintenance.getEntrustedManagementFee();
        this.cleaningFee = maintenance.getCleaningFee();
        this.membershipFee = maintenance.getMembershipFee();
    }
}

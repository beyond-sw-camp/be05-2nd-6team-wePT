package org.encore.apartment.community.domain.maintenance.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.encore.apartment.community.domain.maintenance.data.entity.Maintenance;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class MaintenancePerDto {

    private Long userIdx;

    private double generalMaintenanceFee;

    private double securityServiceFee;

    private double disinfectionFee;

    private double elevatorMaintenanceFee;

    private double intelligentMaintenanceFee;

    private double heatingMaintenanceFee;

    private double hotWaterSupplyFee;

    private double repairFee;

    private double entrustedManagementFee;

    private double cleaningFee;

    private double membershipFee;

//    public static Maintenance toEntity(MaintenanceDto maintenanceDto) {
//        return Maintenance.builder()
//                .maintenanceIdx(0)
//                .paymentDate(new Date())
//                .userIdx(maintenanceDto.getUserIdx())
//                .generalMaintenanceFee(maintenanceDto.getGeneralMaintenanceFee())
//                .intelligentMaintenanceFee(maintenanceDto.getIntelligentMaintenanceFee())
//                .heatingMaintenanceFee(maintenanceDto.getHeatingMaintenanceFee())
//                .hotWaterSupplyFee(maintenanceDto.getHotWaterSupplyFee())
//                .repairFee(maintenanceDto.getRepairFee())
//                .entrustedManagementFee(maintenanceDto.getEntrustedManagementFee())
//                .cleaningFee(maintenanceDto.getCleaningFee())
//                .membershipFee(maintenanceDto.getMembershipFee())
//                .build();
//    }

}

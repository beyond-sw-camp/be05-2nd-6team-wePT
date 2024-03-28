package org.encore.apartment.community.domain.maintenance.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MaintenanceCompDto {

    private Long userIdx;

    private Integer generalMaintenanceFee;

    private Integer securityServiceFee;

    private Integer disinfectionFee;

    private Integer elevatorMaintenanceFee;

    private Integer intelligentMaintenanceFee;

    private Integer heatingMaintenanceFee;

    private Integer hotWaterSupplyFee;

    private Integer repairFee;

    private Integer entrustedManagementFee;

    private Integer cleaningFee;

    private Integer membershipFee;
}

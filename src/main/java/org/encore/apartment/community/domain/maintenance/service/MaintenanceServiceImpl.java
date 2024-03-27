package org.encore.apartment.community.domain.maintenance.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceCompDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenancePerDto;
import org.encore.apartment.community.domain.maintenance.data.entity.Maintenance;
import org.encore.apartment.community.domain.maintenance.data.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("maintenance")
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService{

    public final MaintenanceRepository maintenanceRepository;

    public Integer sum(Maintenance fee){
        Integer sum = 0;
        sum = fee.getGeneralMaintenanceFee()
        + fee.getSecurityServiceFee()
        + fee.getDisinfectionFee()
        + fee.getElevatorMaintenanceFee()
        + fee.getIntelligentMaintenanceFee()
        + fee.getHeatingMaintenanceFee()
        + fee.getHotWaterSupplyFee()
        + fee.getRepairFee()
        + fee.getEntrustedManagementFee()
        + fee.getCleaningFee()
        + fee.getMembershipFee();
        return sum;
    }

    //값 추가
    @Override
    public void addMaintenance(MaintenanceDto params){
        Maintenance res = MaintenanceDto.toEntity(params);
        maintenanceRepository.save(res);
    }

    //내 관리비 읽어오기
    @Override
    public List<MaintenanceDto> readMyMaintenance(Long userIdx){
        List<Maintenance> list = maintenanceRepository.findAllByUserIdx(userIdx);
        return list.stream().map(MaintenanceDto::new).collect(Collectors.toList());
    }

    //내 관리비 총합 (가장 최근 달)
    @Override
    public Integer readMyMaintenanceSum(Long userIdx){
        List<Maintenance> list = maintenanceRepository.findAllByUserIdx(userIdx);
        return sum(list.get(list.size() - 1));
    }

    //관리비 내역 별 비중 조회
    @Override
    public MaintenancePerDto readMyMaintenancePer(Long userIdx){
        List<Maintenance> list = maintenanceRepository.findAllByUserIdx(userIdx);
        Maintenance tmp = list.get(list.size()-1);
        Integer sum = sum(tmp);
        MaintenancePerDto dto = new MaintenancePerDto(
                tmp.getUserIdx(),
                ((double)tmp.getGeneralMaintenanceFee()/sum),
                ((double)tmp.getSecurityServiceFee()/sum),
                ((double)tmp.getDisinfectionFee()/sum),
                ((double)tmp.getElevatorMaintenanceFee()/sum),
                ((double)tmp.getIntelligentMaintenanceFee()/sum),
                ((double)tmp.getHeatingMaintenanceFee()/sum),
                ((double)tmp.getHotWaterSupplyFee()/sum),
                ((double)tmp.getRepairFee()/sum),
                ((double)tmp.getEntrustedManagementFee()/sum),
                ((double)tmp.getCleaningFee()/sum),
                ((double)tmp.getMembershipFee()/sum)
        );
        return dto;
    }


    //관리비 증감액 비교 (저번달 vs 이번달)
    @Override
    public MaintenanceCompDto readMyMaintenanceCom(Long userIdx){
        List<Maintenance> list = maintenanceRepository.findAllByUserIdx(userIdx);
        Maintenance thisM = list.get(list.size() - 1);
        Maintenance befM = new Maintenance(new Date(), thisM.getUserIdx(), 0,0,0,0,0,0,
                0,0,0,0, 0);
        if (list.size() >= 2)
            befM = list.get(list.size()-2);

        MaintenanceCompDto com = new MaintenanceCompDto(
                userIdx,
                (thisM.getGeneralMaintenanceFee() - befM.getGeneralMaintenanceFee()),
                (thisM.getSecurityServiceFee() - befM.getSecurityServiceFee()),
                (thisM.getDisinfectionFee() - befM.getDisinfectionFee()),
                (thisM.getElevatorMaintenanceFee() - befM.getElevatorMaintenanceFee()),
                (thisM.getIntelligentMaintenanceFee() - befM.getIntelligentMaintenanceFee()),
                (thisM.getHeatingMaintenanceFee() - befM.getHeatingMaintenanceFee()),
                (thisM.getHotWaterSupplyFee() - befM.getHotWaterSupplyFee()),
                (thisM.getRepairFee() - befM.getRepairFee()),
                (thisM.getEntrustedManagementFee() - befM.getEntrustedManagementFee()),
                (thisM.getCleaningFee() - befM.getCleaningFee()),
                (thisM.getMembershipFee() - befM.getMembershipFee())
        );
        return com;
    }
}

package org.encore.apartment.community.domain.maintenance.service;

import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceCompDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenancePerDto;
import org.encore.apartment.community.domain.maintenance.data.entity.Maintenance;

import java.util.List;
import java.util.stream.Collectors;

public interface MaintenanceService {
    //값 추가
    public void addMaintenance(MaintenanceDto params);

    //내 관리비 읽어오기
    public List<MaintenanceDto> readMyMaintenance(Long userIdx);
    //내 관리비 총합 (가장 최근 달)
    public Integer readMyMaintenanceSum(Long userIdx);

    //관리비 내역 별 비중 조회
    public MaintenancePerDto readMyMaintenancePer(Long userIdx);

    //관리비 증감액 비교 (저번달 vs 이번달)
    public MaintenanceCompDto readMyMaintenanceCom(Long userIdx);
}

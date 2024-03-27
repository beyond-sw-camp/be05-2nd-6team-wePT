package org.encore.apartment.community.domain.maintenance.ctrl;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.dto.FacilityDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceCompDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenanceDto;
import org.encore.apartment.community.domain.maintenance.data.dto.MaintenancePerDto;
import org.encore.apartment.community.domain.maintenance.service.MaintenanceService;
import org.encore.apartment.community.global.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Resource(name = "maintenance")
    private MaintenanceService service;

    @Operation(summary = "관리비 추가")
    @PostMapping(value = "/add-maintenance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<?> addMaintenance(@Valid @RequestBody MaintenanceDto params) {
        service.addMaintenance(params);

        return ApiResponse.createSuccessWithNoContent();
    }

    @Operation(summary = "관리비 조회")
    @GetMapping(value = "/info/{userIdx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<List<MaintenanceDto>> readMyMaintenance(@PathVariable("userIdx") Long userIdx) {
        List<MaintenanceDto> list = service.readMyMaintenance(userIdx);
        return ApiResponse.createSuccess(list);
    }

    @Operation(summary = "내 관리비 총합 (가장 최근 달)")
    @GetMapping(value = "/info-sum/{userIdx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<Integer> readMyMaintenanceSum(@PathVariable("userIdx") Long userIdx) {
        Integer res = service.readMyMaintenanceSum(userIdx);
        return ApiResponse.createSuccess(res);
    }

    @Operation(summary = "관리비 내역 별 비중 조회")
    @GetMapping(value = "/info-per/{userIdx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<MaintenancePerDto> readMyMaintenancePer(@PathVariable("userIdx") Long userIdx) {
        MaintenancePerDto res = service.readMyMaintenancePer(userIdx);
        return ApiResponse.createSuccess(res);
    }

    @Operation(summary = "지난 달과 관리비 증감액 비교")
    @GetMapping(value = "/info-comp/{userIdx}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ApiResponse<MaintenanceCompDto> readMyMaintenanceCom(@PathVariable("userIdx") Long userIdx) {
        MaintenanceCompDto res = service.readMyMaintenanceCom(userIdx);
        return ApiResponse.createSuccess(res);
    }
}
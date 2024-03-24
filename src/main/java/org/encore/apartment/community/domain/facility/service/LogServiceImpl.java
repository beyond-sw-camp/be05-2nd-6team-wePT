package org.encore.apartment.community.domain.facility.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.encore.apartment.community.domain.facility.data.dto.LogDto;
import org.encore.apartment.community.domain.facility.data.entity.Log;
import org.encore.apartment.community.domain.facility.data.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("log")
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    //추가 (exit_time = null) -> userID & facilityID 필요
    public void addLog(Integer facilityId, String userId){
        Log add = Log.builder()
                .logFacilityId(facilityId)
                .logUserId(userId)
                .build();
        logRepository.save(add);
    }

    //조회 (전체 확인용)
    @Override
    public List<LogDto> readAllLog(){
        List<Log> list = logRepository.findAll();
        return list.stream().map(LogDto::new).collect(Collectors.toList());
    }

    //시설 아이디로 조회 (들어가 있는 사람 조회)(exit_time = null)
    @Override
    public List<LogDto> readAllByFacilityUsers(Integer facilityId){
        List<Log> list = logRepository.findAllByLogFacilityId(facilityId);
        return list.stream().map(LogDto::new).collect(Collectors.toList());
    }

    //사용자 아이디로 조회 (exit_time = null)
    @Override
    public List<LogDto> readAllByUsers(String userId){
        List<Log> list = logRepository.findAllByLogUserId(userId);
        List<Log> res = new ArrayList<>();
        for (Log log : list){
            if (log.getLogExitTime() == null)
                res.add(log);
        }
        return res.stream().map(LogDto::new).collect(Collectors.toList());
    }

    //수정 (exit_time = sysdate) userId
    @Override
    public void updateUserNums(String userId){
        Date date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        if (readAllByUsers(userId).size() == 1) {
            List<Log> list = logRepository.findAllByLogUserId(userId);
            for (Log log : list) {
                if (log.getLogExitTime() == null) {
                    Log tmp = Log.builder()
                            .logId(log.getLogId())
                            .logUserId(log.getLogUserId())
                            .logFacilityId(log.getLogFacilityId())
                            .logEntryTime(log.getLogEntryTime())
                            .logExitTime(date)
                            .build();
                    logRepository.save(tmp);
                }
            }
        }
    }

}

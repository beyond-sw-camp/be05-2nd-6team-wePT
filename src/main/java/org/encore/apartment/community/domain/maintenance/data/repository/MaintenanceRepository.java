package org.encore.apartment.community.domain.maintenance.data.repository;

import org.encore.apartment.community.domain.maintenance.data.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
    List<Maintenance> findAllByUserIdx(Long userIdx);
}

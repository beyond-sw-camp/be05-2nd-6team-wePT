package org.encore.apartment.community.domain.apartment.data.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.apartment.data.entity.Apartment;
import org.encore.apartment.community.domain.user.data.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE Apartment A SET A.apartmentName = :apartmentName, A.apartmentAddress = :apartmentAddress, A.apartmentTotalHousehold = :apartmentTotalHousehold WHERE A.apartmentId = :apartmentId")
	public void updateEntity(@Param("apartmentId") Long apartmentId, @Param("apartmentName") String apartmentName,
		@Param("apartmentAddress") String apartmentAddress, @Param("apartmentTotalHousehold") Integer apartmentTotalHousehold);
}

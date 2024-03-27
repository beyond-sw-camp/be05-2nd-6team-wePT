package org.encore.apartment.community.domain.facility.data.repository;

import java.util.List;

import org.encore.apartment.community.domain.facility.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
	/*reservation_user_id(user_id)로 본인 예약 찾기 (완전 id가 동일해야함)*/
	List<Reservation> findAllByReservationUserId(String userId);
}

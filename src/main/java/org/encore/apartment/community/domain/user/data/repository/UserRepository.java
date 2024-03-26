package org.encore.apartment.community.domain.user.data.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// matchingserviceimpl의 toentity에서 사용 중
	public Optional<User> findByUserId(String userId);
}

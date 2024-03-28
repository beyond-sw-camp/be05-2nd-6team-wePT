package org.encore.apartment.community.domain.user.repository;

import java.util.Optional;

import org.encore.apartment.community.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserId(String userId);
    Optional<User> findByUserIdx(Long userIdx);
	Optional<User> findByUserEmail(String email);
}

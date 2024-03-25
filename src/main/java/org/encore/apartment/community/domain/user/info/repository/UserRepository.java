package org.encore.apartment.community.domain.user.info.repository;

import org.encore.apartment.community.domain.user.info.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

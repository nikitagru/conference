package com.nikitagru.conference.repository;

import com.nikitagru.conference.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UsersRoleRepository extends JpaRepository<UserRole, Long> {
    @Query(value = "INSERT INTO users_roles (user_id, role_id) VALUES (:#{#id}, 3)", nativeQuery = true)
    @Modifying
    @Transactional
    void saveNewUser(@Param("id") long id);
}

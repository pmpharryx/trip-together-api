package com.triptogether.api.auth.repository;

import com.triptogether.api.common.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;


public interface AuthRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByMobileNo(String mobileNo);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.password = :newPassword WHERE user.userId = :userId")
    void updatePassword(UUID userId, String newPassword);
}

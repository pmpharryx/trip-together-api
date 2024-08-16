package com.triptogether.api.user.repository;

import com.triptogether.api.common.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.username = :newUsername WHERE user.userId = :userId")
    void updateUsername(UUID userId, String newUsername);

    @Modifying
    @Transactional
    @Query("UPDATE User user SET user.username = :newEmail WHERE user.userId = :userId")
    void updateEmail(UUID userId, String newEmail);
}

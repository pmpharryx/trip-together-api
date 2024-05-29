package com.triptogether.api.auth.repository;

import com.triptogether.api.common.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<User, UUID> {

}

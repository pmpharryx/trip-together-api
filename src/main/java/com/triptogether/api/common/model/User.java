package com.triptogether.api.common.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public User(String username, String password, String mobileNo) {
        this.username = username;
        this.password = password;
        this.mobileNo = mobileNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile_no", length = 15, nullable = false, unique = true)
    private String mobileNo;

    @Column(name = "created_by", nullable = false)
    private String createdBy = "System";

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_by")
    private String updatedBy = "System";

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();
}

package com.rodrigo.user_management_api.repository;

import com.rodrigo.user_management_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

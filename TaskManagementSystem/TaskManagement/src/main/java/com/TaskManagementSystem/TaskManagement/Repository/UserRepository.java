package com.TaskManagementSystem.TaskManagement.Repository;

import com.TaskManagementSystem.TaskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.user_email=?1")
    Optional<User> findUsersByEmail(String userEmail);
}

package com.TaskManagementSystem.TaskManagement.Repository;

import com.TaskManagementSystem.TaskManagement.entity.Cart;
import com.TaskManagementSystem.TaskManagement.entity.Product;
import com.TaskManagementSystem.TaskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    @Query("SELECT p FROM Product p Where p.product_name = ?1")
    List<Cart> findCartByName(String email);

    @Query("SELECT u FROM User u Where u.user_email= ?1")
    List<Cart> findUserByEmal(String email);
}

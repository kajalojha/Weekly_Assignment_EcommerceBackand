package com.TaskManagementSystem.TaskManagement.Repository;

import com.TaskManagementSystem.TaskManagement.entity.Product;
import com.TaskManagementSystem.TaskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product , Integer> {
@Query("SELECT p FROM Product p WHERE p.product_name = ?1")
Optional<Product> findProductByName(String product_name);

}

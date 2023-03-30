package com.example.onlinestorebackend.repositories;

import com.example.onlinestorebackend.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Marko
 * @Date 30/03/2023
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    Optional<OrderLine> findById(Long id);
}

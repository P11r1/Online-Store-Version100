package com.example.onlinestorebackend.repositories;

import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marko
 * @Date 30/03/2023
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
    List<OrderLine> findAllByProductAndUser(Product product, User user);
    List<OrderLine> findOrderLinesByUser(User user);




}

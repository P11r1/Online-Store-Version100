package com.example.onlinestorebackend.repositories;

import com.example.onlinestorebackend.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {

}

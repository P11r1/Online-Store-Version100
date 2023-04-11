package com.example.onlinestorebackend.repositories;

import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.models.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Marko
 * @Date 11/04/2023
 */
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
//    Optional<UserAddress> findUserAddressById(Long id);

}

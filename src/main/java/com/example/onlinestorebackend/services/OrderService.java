package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.models.Order;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.User;

/**
 * @author Marko
 * @Date 11/04/2023
 */
public interface OrderService {
    void createOrderByUser(User user);
}

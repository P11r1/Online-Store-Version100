package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.models.OrderDetails;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.User;

/**
 * @author Marko
 * @Date 11/04/2023
 */
public interface OrderDetailService {
    void createOrderDetailByOrderLine(OrderDetails orderDetails, User user, OrderLine orderLine);

}

package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.models.OrderDetails;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.repositories.OrderDetailRepository;
import com.example.onlinestorebackend.services.OrderDetailService;
import com.example.onlinestorebackend.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Transactional
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderLineService orderLineService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public void createOrderDetailByOrderLine(OrderDetails orderDetails, User user, OrderLine orderLine) {
        List<OrderLine> orderLineList = orderLineService.findActiveOrderLineByUser(user);
        orderDetails.setOrderLines(orderLineList);
        orderDetails.setUser(user);
        orderDetails.setTotalPrice(orderLine.getProductPrice());
        orderDetails.setActive(true);
        orderDetailRepository.save(orderDetails);

    }
}

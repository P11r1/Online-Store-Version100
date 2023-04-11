package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.exceptions.OrderLineNotFoundException;
import com.example.onlinestorebackend.models.Order;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.Status;
import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.repositories.OrderRepository;
import com.example.onlinestorebackend.services.OrderLineService;
import com.example.onlinestorebackend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderLineService orderLineService;
//    @Override
//    public void createOrderByUser(User user) {
//    OrderDetails orderDetails = orderLineService.findActiveOrderDetailsByUser(user);
//        List<OrderLine> orderLines = orderLineService.findActiveOrderLineByUser(user);
//        Order order = new Order();
//        order.setOrderLines(orderLines);
//        order.setDeliveryAddress(order.getDeliveryAddress());
//        order.setUser(user);
//        order.setStatus(Status.ACTIVE);
//        orderRepository.save(order);
//
//    }

//    public List<OrderLine> findActiveOrderLineByUser(User user) {
//        return orderRepository.findOrderLinesByUser(user).stream()
//                .filter(OrderLine::isActive)
//                .collect(Collectors.toList());
//    }
}

package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.models.*;
import com.example.onlinestorebackend.services.CartService;
import com.example.onlinestorebackend.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/29/2023
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderLineService orderLineService;



    @Override
    public Cart getCartByUser(User user) {
        List<OrderLine> orderLineList = orderLineService.findActiveOrderLineByUser(user);

        float totalCost = 0;

        float totalQty = 0;

        for(OrderLine orderLine: orderLineList) {
            totalCost += orderLine.getProductPrice();
            totalQty += orderLine.getQtyOfProducts();
        }


        Cart cart = new Cart();
        cart.setTotalCost(totalCost);
        cart.setTotalQty(totalQty);
        cart.setOrderLines(orderLineList);

        return cart;
    }
}
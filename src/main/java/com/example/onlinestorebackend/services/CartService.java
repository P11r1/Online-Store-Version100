package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.exceptions.CartNotFoundException;
import com.example.onlinestorebackend.exceptions.OrderLineNotFoundException;
import com.example.onlinestorebackend.models.Cart;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.models.User;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/29/2023
 */
public interface CartService {
    Cart getCartByUser(User user);

}
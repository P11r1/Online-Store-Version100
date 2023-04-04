package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.exceptions.CartNotFoundException;
import com.example.onlinestorebackend.exceptions.CategoryNotFoundException;
import com.example.onlinestorebackend.exceptions.OrderLineNotFoundException;
import com.example.onlinestorebackend.models.*;
import com.example.onlinestorebackend.repositories.CartRepository;
import com.example.onlinestorebackend.repositories.OrderLineRepository;
import com.example.onlinestorebackend.services.CartService;
import com.example.onlinestorebackend.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Bahadir Tasli
 * @Date 3/29/2023
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private OrderLineService orderLineService;


    @Override
    public void createCartByOrderLine(OrderLine orderLine) {
        try {
            Cart cart = findCartById(orderLine.getId());
            cart.setTotalCost(orderLine.getProductPrice());
            cartRepository.saveAndFlush(cart);
        } catch (RuntimeException | CartNotFoundException exception) {
            Cart cart = new Cart();
            cart.setOrderLines(cart.getOrderLines());
            cart.setTotalCost(orderLine.getProductPrice());
            orderLine.setActive(true);
            cartRepository.save(cart);
        }
    }


    @Override
    public Cart findCartById(Long id) throws CartNotFoundException {
        Optional<Cart> cartOptional = cartRepository.findById(id);

        if (cartOptional.isEmpty()) {
            throw new CartNotFoundException(id);
        }
        return cartOptional.get();
    }




    @Override
    public void removeOrderLineFromCart(OrderLine orderLine) {

    }

    @Override
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);

    }

    @Override
    public void updateCart(Cart cart) throws CartNotFoundException {

        if (findCartById(cart.getId()) != null) {
            cartRepository.saveAndFlush(cart);
        }
    }



    @Override
    public void deleteCartById(Long id) throws CartNotFoundException {
        Cart cart = findCartById(id);
        cart.setActive(false);
        cartRepository.saveAndFlush(cart);
    }

    @Override
    public void restoreCartById(Long id) throws CartNotFoundException {
        Cart cart = findCartById(id);
        cart.setActive(true);
        cartRepository.saveAndFlush(cart);
    }
}

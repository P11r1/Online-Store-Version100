package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.exceptions.CartNotFoundException;
import com.example.onlinestorebackend.models.Cart;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.repositories.CartRepository;
import com.example.onlinestorebackend.services.CartService;
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

    @Override
    public Cart addItemToCart(Product product, int quantity, User user) {
        Cart cart = user.getCart();
    }

    @Override
    public Cart updateItemInCart(Product product, int quantity, User user) {
        return null;
    }

    @Override
    public Cart deleteItemFromCart(Product product, User user) {
        return null;
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
    public Cart findCartById(Long id) throws CartNotFoundException {
        Optional<Cart> cartOptional = cartRepository.findById(id);

        if (cartOptional.isEmpty()) {
            throw new CartNotFoundException(id);
        }
        return cartOptional.get();
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

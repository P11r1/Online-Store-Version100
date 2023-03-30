package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.exceptions.CartNotFoundException;
import com.example.onlinestorebackend.models.Cart;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.models.User;

import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/29/2023
 */
public interface CartService {

    Cart addItemToCart(Product product, int quantity, User user);

    Cart updateItemInCart(Product product, int quantity, User user);

    Cart deleteItemFromCart(Product product, User user);


//    /**
//     *
//     * @return List of products
//     */
//    List<Product> getProductsToCart();
//
//    /**
//     * To get Product price
//     *
//     * @param product Product
//     */
//    void getProductPrice(Product product);

    /**
     * To find all carts
     *
     * @return list of Cart
     */
    List<Cart> findAllCarts();

    /**
     * To create a new cart
     *
     * @param cart Cart
     */
    void createCart(Cart cart);

    /**
     * To update an existing Cart
     *
     * @param cart Cart
     * @throws CartNotFoundException
     */
    void updateCart(Cart cart) throws CartNotFoundException;

    /**
     * To update an existing Cart
     *
     * @param id Id
     * @return Cart
     */
    Cart findCartById(Long id) throws CartNotFoundException;

    /**
     * To delete cart by id
     *
     * @param id Id
     */
    void deleteCartById(Long id) throws CartNotFoundException;

    /**
     * To restore cart by id
     *
     * @param id Id
     */
    void restoreCartById(Long id) throws CartNotFoundException;

}

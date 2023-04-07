package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.exceptions.ProductNotFoundException;
import com.example.onlinestorebackend.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author joozepp
 * @Date 3/22/2023
 */
public interface ProductService {

    /**
     * To create a new product
     *
     * @param product Product
     */
    void createProduct(Product product, MultipartFile imageProduct) throws IOException;

    /**
     * To find a product by title
     *
     * @param title Title
     * @return Product
     */
    Product findProductByTitle(String title) throws ProductNotFoundException;

    /**
     * To find all Products
     * @return list of Products
     */
    List<Product> findAllProducts();


    /**
     * To update an existing Product
     * @param product Product
     */
    void updateProduct(Product product) throws ProductNotFoundException;

    /**
     * To delete a Product by title
     * @param title Title
     */
    void deleteProductByTitle(String title) throws ProductNotFoundException;

    /**
     * To restore Product by title
     * @param title Title
     *
     */
    void restoreProductByTitle(String title) throws ProductNotFoundException;

    /**
     * to find a product by ID
     *
     * @param id Product ID
     * @return Product
     */
    Product findProductById(Long id) throws ProductNotFoundException;
}
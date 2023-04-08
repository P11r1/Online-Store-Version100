package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.exceptions.ProductNotFoundException;
import com.example.onlinestorebackend.exceptions.SubCategoryNotFoundException;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.models.SubCategory;
import com.example.onlinestorebackend.repositories.ProductRepository;
import com.example.onlinestorebackend.services.ProductService;
import com.example.onlinestorebackend.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * @author joozepp
 * @Date 3/23/2023
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SubCategoryService subCategoryService;

    @Override
    public void createProduct(Product product)  {
        SubCategory subCategory = null;
        try {
            subCategory = subCategoryService.findSubCategoryById(product.getSubCategory().getId());
        } catch (SubCategoryNotFoundException e) {
            throw new RuntimeException(e);
        }

        product.setSubCategory(subCategory);
        product.setActive(true);
        productRepository.save(product);
    }

    @Override
    public Product findProductByTitle(String title) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findByTitle(title);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(title);
        }
        return productOptional.get();
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) throws ProductNotFoundException {

        if (findProductById(product.getId()) !=null) {
            productRepository.saveAndFlush(product);
        }

    }

    @Override
    public void deleteProductByTitle(String title) throws ProductNotFoundException {
        Product product = findProductByTitle(title);
        product.setActive(false);
        productRepository.saveAndFlush(product);
    }

    @Override
    public void restoreProductByTitle(String title) throws ProductNotFoundException {
        Product product = findProductByTitle(title);
        product.setActive(true);
        productRepository.saveAndFlush(product);
    }

    @Override
    public Product findProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        return productOptional.get();

    }
}
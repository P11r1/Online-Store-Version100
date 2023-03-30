package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.exceptions.OrderLineNotFoundException;
import com.example.onlinestorebackend.exceptions.ProductNotFoundException;
import com.example.onlinestorebackend.models.OrderLine;
import com.example.onlinestorebackend.models.Product;
import com.example.onlinestorebackend.repositories.OrderLineRepository;
import com.example.onlinestorebackend.repositories.ProductRepository;
import com.example.onlinestorebackend.services.OrderLineService;
import com.example.onlinestorebackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Marko
 * @Date 30/03/2023
 */
@Service
@Transactional
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProductToOrderLine(Product product) throws ProductNotFoundException {
        Product existingProduct = productService.findProductByTitle(product.getTitle());
        existingProduct.setActive(true);
        productRepository.save(existingProduct);
    }

    @Override
    public void createOrderLine(OrderLine orderLine) {
        orderLine.setActive(true);
        orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine findOrderLineById(Long id) throws OrderLineNotFoundException {
        Optional<OrderLine> orderLineOptional = orderLineRepository.findById(id);

        if (orderLineOptional.isEmpty()) {
            throw new OrderLineNotFoundException(id);
        }
        return orderLineOptional.get();
    }

    @Override
    public List<OrderLine> findAllOrderLines() {
        return orderLineRepository.findAll();
    }

    @Override
    public void deleteOrderLineById(Long id) throws OrderLineNotFoundException {
        OrderLine orderLine = findOrderLineById(id);
        orderLine.setActive(false);
        orderLineRepository.saveAndFlush(orderLine);
    }

    @Override
    public void restoreOrderLineById(Long id) throws OrderLineNotFoundException {
        OrderLine orderLine = findOrderLineById(id);
        orderLine.setActive(true);
        orderLineRepository.saveAndFlush(orderLine);
    }
}

package com.example.onlinestorebackend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Marko
 * @Date 30/03/2023
 */
@Entity
@Data
@EqualsAndHashCode
public class OrderLine extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private Product product;
    private float qtyOfProducts;

    private float productPrice;

    private boolean isActive;
    @OneToOne(cascade = CascadeType.MERGE)
    private Cart cart;
    @OneToOne(cascade = CascadeType.MERGE)
    private User user;
}

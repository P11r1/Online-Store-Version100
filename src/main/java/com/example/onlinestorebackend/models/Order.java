package com.example.onlinestorebackend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/21/2023
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String deliveryAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;


}

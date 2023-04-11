package com.example.onlinestorebackend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class UserAddress extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String city;
    private String country;
    private boolean isActive;
    private boolean isPrimaryDeliveryAddress;
}

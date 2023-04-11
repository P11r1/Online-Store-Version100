package com.example.onlinestorebackend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/23/2023
 */

@Data
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<OrderLine> orderLines;
    private float totalCost;

    private float totalQty;

}

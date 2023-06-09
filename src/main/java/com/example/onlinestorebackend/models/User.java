package com.example.onlinestorebackend.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Bahadir Tasli
 * @Date 3/21/2023
 */
@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends Auditable<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    private String email;
    private String password;
    @ManyToMany
    private List<UserAddress> userAddressList;

    private String logoType;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.MERGE)
    private Author author;

    private boolean isActive;

}

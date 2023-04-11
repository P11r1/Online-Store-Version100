package com.example.onlinestorebackend.services;

import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.models.UserAddress;

/**
 * @author Marko
 * @Date 11/04/2023
 */
public interface UserAddressService {

    void createUserAddress(UserAddress userAddress);

    UserAddress findActivePrimaryAddressByUser(User user);
}

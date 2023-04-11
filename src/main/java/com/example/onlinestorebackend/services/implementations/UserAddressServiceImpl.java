package com.example.onlinestorebackend.services.implementations;

import com.example.onlinestorebackend.models.User;
import com.example.onlinestorebackend.models.UserAddress;
import com.example.onlinestorebackend.repositories.UserAddressRepository;
import com.example.onlinestorebackend.services.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Marko
 * @Date 11/04/2023
 */
@Service
@Transactional
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public void createUserAddress(UserAddress userAddress) {
        userAddress.setActive(true);
        userAddressRepository.save(userAddress);

    }

    @Override
    public UserAddress findActivePrimaryAddressByUser(User user) {
      return user.getUserAddressList().stream()
                .filter(UserAddress::isActive)
               .filter(UserAddress::isPrimaryDeliveryAddress)
              .findFirst().orElse(null);
    }
}


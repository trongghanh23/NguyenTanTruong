package com.example.smartphones.service.cart;

import com.example.smartphones.dto.IBookingDto;
import com.example.smartphones.dto.SmartphoneDto;

import java.util.List;
import java.util.Optional;

public interface IOderSmartphoneService {
    List<SmartphoneDto> findCartByUser(Integer id);
    void ascQuantity(Integer id);

    void descQuantity( Integer id);


    Optional<IBookingDto> getCartCount(Integer id);

    void addSmartphone(Integer quantity, Integer customerId,Integer smartphoneId);
}

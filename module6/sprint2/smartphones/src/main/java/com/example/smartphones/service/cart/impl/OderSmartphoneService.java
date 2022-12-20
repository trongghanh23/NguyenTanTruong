package com.example.smartphones.service.cart.impl;

import com.example.smartphones.dto.IBookingDto;
import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.model.OderSmartphone;
import com.example.smartphones.repository.OderRepository;
import com.example.smartphones.service.cart.IOderSmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderSmartphoneService implements IOderSmartphoneService {
    @Autowired
    private OderRepository oderRepository;

    @Override
    public List<SmartphoneDto> findCartByUser(Integer id) {
        return oderRepository.findCartByUser(id);
    }

    @Override
    public void ascQuantity(Integer id) {
        oderRepository.ascQuantity(id);
    }

    @Override
    public void descQuantity(Integer id) {
        oderRepository.descQuantity(id);

    }

    @Override
    public Optional<IBookingDto> getCartCount(Integer id) {
        return oderRepository.getCartCount(id);
    }

    @Override
    public void addSmartphone(Integer quantity, Integer customerId, Integer smartphoneId) {
        Optional<OderSmartphone> bookingSmartphone = oderRepository.getBookingSmartphoneCart(customerId, smartphoneId);

        if (bookingSmartphone.isPresent()) {
            oderRepository.setQuantitySmartphone(bookingSmartphone.get().getQuantity() + quantity, customerId, smartphoneId);
        } else {
            oderRepository.addSmartphone(quantity, customerId, smartphoneId);
        }
    }
}

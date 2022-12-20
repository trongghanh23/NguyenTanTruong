package com.example.smartphones.service.cart;

import com.example.smartphones.dto.SmartphoneDto;

import java.util.List;

public interface IOderSmartphoneService {
    List<SmartphoneDto> findCartByUser(Integer id);
}

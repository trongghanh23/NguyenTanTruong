package com.example.smartphones.service.cart.impl;

import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.repository.OderRepository;
import com.example.smartphones.service.cart.IOderSmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OderSmartphoneService implements IOderSmartphoneService {
    @Autowired
    private OderRepository oderRepository;
    @Override
    public List<SmartphoneDto> findCartByUser(Integer id) {
        return oderRepository.findCartByUser(id);
    }
}

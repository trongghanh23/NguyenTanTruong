package com.example.smartphones.service.smartphone.impl;

import com.example.smartphones.model.smartphone.SmartphoneType;
import com.example.smartphones.repository.smartphone.SmartphoneTypeRepository;
import com.example.smartphones.service.smartphone.ISmartphoneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SmartphoneTypeService implements ISmartphoneTypeService {
    @Autowired
    private SmartphoneTypeRepository smartphoneTypeRepository;
    @Override
    public List<SmartphoneType> findAll() {
        return smartphoneTypeRepository.findAll();
    }
}

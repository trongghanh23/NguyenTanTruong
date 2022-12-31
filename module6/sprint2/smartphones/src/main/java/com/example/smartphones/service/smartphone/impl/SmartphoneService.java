package com.example.smartphones.service.smartphone.impl;

import com.example.smartphones.dto.IHistoryDto;
import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.repository.smartphone.SmartphoneRepository;
import com.example.smartphones.service.smartphone.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;
    @Override
    public Page<SmartphoneDto> findAllHome(String name, Pageable pageable) {
        return smartphoneRepository.findAllSmartphone(pageable, name);
    }

    @Override
    public Page<SmartphoneDto> findAllHomeType(String name, Pageable pageable) {
        return smartphoneRepository.findAllSmartphoneType(pageable, name);
    }

    @Override
    public Optional<SmartphoneDto> detailSmartphone(Integer id) {
        return smartphoneRepository.detailSmartphone(id);
    }

    @Override
    public Page<IHistoryDto> getAllHistory(String username, Pageable pageable) {
        return smartphoneRepository.getAll(username, pageable);
    }


}

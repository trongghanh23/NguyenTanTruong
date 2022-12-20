package com.example.smartphones.service.smartphone.impl;

import com.example.smartphones.model.smartphone.Specifications;
import com.example.smartphones.repository.smartphone.SpecificationsRepository;
import com.example.smartphones.service.smartphone.ISpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationsService implements ISpecificationsService {
    @Autowired
    private SpecificationsRepository specificationsRepository;
    @Override
    public List<Specifications> findAll() {
        return specificationsRepository.findAll();
    }
}

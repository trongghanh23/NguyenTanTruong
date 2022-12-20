package com.example.smartphones.service.customer.impl;

import com.example.smartphones.model.customer.CustomerType;
import com.example.smartphones.repository.customer.CustomerTypeRepository;
import com.example.smartphones.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findCustomerType() {
        return customerTypeRepository.findAll();
    }
}

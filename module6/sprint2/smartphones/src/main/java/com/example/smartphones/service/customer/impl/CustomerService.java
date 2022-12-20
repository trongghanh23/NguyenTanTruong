package com.example.smartphones.service.customer.impl;

import com.example.smartphones.dto.ICustomerDto;
import com.example.smartphones.model.customer.Customer;
import com.example.smartphones.repository.customer.CustomerRepository;
import com.example.smartphones.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer findFakeMail(String email) {
        return null;
    }

    @Override
    public int saveCreateGmail(Customer customer) {
        return 0;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerRepository.findCustomerByUsername(username);
    }

//    @Override
//    public Optional<ICustomerDto> findCustomerByUsername(String username) {
//        return customerRepository.findCustomer(username);
//    }
}

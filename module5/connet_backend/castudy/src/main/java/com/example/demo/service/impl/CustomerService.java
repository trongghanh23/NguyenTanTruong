package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Page<Customer> getCustomer(String nameCustomer, Pageable pageable) {
        return customerRepository.findByName(nameCustomer, pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public Optional<Customer> getId(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepository.save(customer);
    }


}

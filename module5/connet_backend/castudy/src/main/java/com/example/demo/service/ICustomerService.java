package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {

    Page<Customer> getCustomer(String nameCustomer, Pageable pageable);

    void save(Customer customer);

    Optional<Customer> getId(int id);

    void deleteCustomer(Integer id);

    void editCustomer(Customer customer);


}

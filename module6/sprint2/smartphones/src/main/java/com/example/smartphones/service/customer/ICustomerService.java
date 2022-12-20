package com.example.smartphones.service.customer;

import com.example.smartphones.dto.ICustomerDto;
import com.example.smartphones.model.customer.Customer;

import java.util.Optional;

public interface ICustomerService {
    Customer findFakeMail(String email);

    int saveCreateGmail(Customer customer);

//    Optional<ICustomerDto> findCustomerByUsername(String username);

    Customer findCustomerByUsername( String username);
}

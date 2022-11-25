package com.example.demo.controller;


import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerType;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin()
@RestController
@RequestMapping("/customer")
public class CustomerRestController {
    @Autowired
    private ICustomerService iCustomerService;
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Customer>> getPageCustomer(
            @PageableDefault() Pageable pageable,
            @RequestParam(defaultValue = "") String name) {
        Page<Customer> customers = this.iCustomerService.getCustomer(name, pageable);

        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
    }
    @GetMapping("/customerType")
    public ResponseEntity<List<CustomerType>> getRankList() {
        List<CustomerType> customerRanks = iCustomerTypeService.findAll();

        if (customerRanks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerRanks, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id) {

        Customer customer = iCustomerService.getId(id).get();
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> saveAdding(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Customer> saveEditing(@RequestBody CustomerDto customerDto,
                                                @PathVariable int id) {
        Customer customer = iCustomerService.getId(id).get();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.editCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
        Optional<Customer> customer = iCustomerService.getId(id);
        if (customer.isPresent()) {
            iCustomerService.deleteCustomer(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

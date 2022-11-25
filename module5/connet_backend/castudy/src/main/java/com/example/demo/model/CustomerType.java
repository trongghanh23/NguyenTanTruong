package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.web.JsonPath;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    private Integer id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}

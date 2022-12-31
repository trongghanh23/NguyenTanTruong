package com.example.smartphones.model;


import com.example.smartphones.model.customer.Customer;

import javax.persistence.*;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isDelete;
    private String smartphoneBookingTime;
    private int status;
    private int price;
    private int quantity;


    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public History() {
    }

    public History(Integer id, String name, boolean isDelete, String smartphoneBookingTime, int status, int price, int quantity, Customer customer) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.smartphoneBookingTime = smartphoneBookingTime;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.customer = customer;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getSmartphoneBookingTime() {
        return smartphoneBookingTime;
    }

    public void setSmartphoneBookingTime(String smartphoneBookingTime) {
        this.smartphoneBookingTime = smartphoneBookingTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
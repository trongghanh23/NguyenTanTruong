package com.example.smartphones.model;

import com.example.smartphones.model.customer.Customer;
import com.example.smartphones.model.smartphone.Smartphone;

import javax.persistence.*;

@Entity
public class OderSmartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String timeBookSmartphone;
    private boolean isDelete;
    private int quantity;
    private boolean status;


    @JoinColumn(name = "smartphoneId",referencedColumnName = "id")
    @ManyToOne
    private Smartphone smartphone;
     @JoinColumn(name = "customerId",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    public OderSmartphone() {
    }

    public OderSmartphone(Integer id, String timeBookSmartphone, boolean isDelete, int quantity, boolean status, Smartphone smartphone, Customer customer) {
        this.id = id;
        this.timeBookSmartphone = timeBookSmartphone;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.status = status;
        this.smartphone = smartphone;
        this.customer = customer;
    }

    public String getTimeBookSmartphone() {
        return timeBookSmartphone;
    }

    public void setTimeBookSmartphone(String timeBookSmartphone) {
        this.timeBookSmartphone = timeBookSmartphone;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

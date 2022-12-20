package com.example.smartphones.model.smartphone;

import com.example.smartphones.model.customer.Customer;

import javax.persistence.*;

@Entity
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean isDelete;
    private String insurance;
    private String producer;
    private String price;

    @JoinColumn(name = "type_smartphone_id",referencedColumnName = "id")
    @ManyToOne
    private SmartphoneType smartphoneType;

    @JoinColumn(name = "specifications_id",referencedColumnName = "id")
    @ManyToOne
    private Specifications specifications;

    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    public Smartphone() {
    }

    public Smartphone(Integer id, boolean isDelete, String insurance, String producer, String price, SmartphoneType smartphoneType, Specifications specifications, Customer customer) {
        this.id = id;
        this.isDelete = isDelete;
        this.insurance = insurance;
        this.producer = producer;
        this.price = price;
        this.smartphoneType = smartphoneType;
        this.specifications = specifications;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SmartphoneType getSmartphoneType() {
        return smartphoneType;
    }

    public void setSmartphoneType(SmartphoneType smartphoneType) {
        this.smartphoneType = smartphoneType;
    }

    public Specifications getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specifications specifications) {
        this.specifications = specifications;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

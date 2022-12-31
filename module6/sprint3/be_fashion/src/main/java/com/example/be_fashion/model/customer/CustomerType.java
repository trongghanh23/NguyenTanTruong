package com.example.be_fashion.model.customer;

import javax.persistence.*;

@Entity
@Table
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private boolean isDelete;

}

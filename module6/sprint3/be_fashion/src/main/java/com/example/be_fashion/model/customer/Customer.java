package com.example.be_fashion.model.customer;

import com.example.be_fashion.model.decentralization.User;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean isDelete;
    private String name;
    private String dayOfBirth;
    private Integer gender;
    private String idCard;
    private String email;
    @Column(columnDefinition = "text")
    private String address;
    private String phoneNumber;

    @JoinColumn(name = "idCustomerType",referencedColumnName = "id")
    @ManyToOne
    private CustomerType customerType;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")

    private User user;

}

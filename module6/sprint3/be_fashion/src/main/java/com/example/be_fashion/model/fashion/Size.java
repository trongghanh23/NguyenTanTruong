package com.example.be_fashion.model.fashion;

import javax.persistence.*;

@Entity
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

}

package com.example.be_fashion.model.fashion;

import javax.persistence.*;

@Entity
@Table
public class SeasonalFashion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

}

package com.example.be_fashion.model.fashion;
import com.example.be_fashion.model.customer.Customer;

import javax.persistence.*;

@Entity
@Table
public class Fashion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(columnDefinition = "text")
    private String image;

    @JoinColumn(name = "idFashionType",referencedColumnName = "id")
    @ManyToOne
    private FashionType fashionType;

    @JoinColumn(name = "idSeasonalFashion",referencedColumnName = "id")
    @ManyToOne
    private SeasonalFashion seasonalFashion;

    @JoinColumn(name = "idSize",referencedColumnName = "id")
    @ManyToOne
    private Size size;

    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;
}

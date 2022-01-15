package com.WebApi.webapi.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;

    public Product(long nId,String nName, double nPrice){
        id = nId;
        name = nName;
        price = nPrice;
    }

    public Product(String nName, double nPrice){
        name = nName;
        price = nPrice;
    }

}

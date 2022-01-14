package com.WebApi.webapi.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
}

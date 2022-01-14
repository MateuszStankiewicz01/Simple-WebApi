package com.WebApi.webapi.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class ProductValidator {

    @Size(min=1,max=100)
    private String m_name;
    @DecimalMin("0.00")
    private double m_price;

    ProductValidator(String name,double price){
        Assert.notNull(name,"name should not be null");
        m_name = name;
        m_price = price;
    }
}

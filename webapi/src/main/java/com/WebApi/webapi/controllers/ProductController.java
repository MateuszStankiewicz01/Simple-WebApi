package com.WebApi.webapi.controllers;

import lombok.AllArgsConstructor;
import com.WebApi.webapi.models.Product;
import com.WebApi.webapi.models.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.WebApi.webapi.services.ProductService;


import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;


    @GetMapping("/api/products")
    public List<Product> get(){
        return  productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public Product get(@PathVariable("id") long id){
        return  productService.getProductById(id);
    }

    @PostMapping("/api/products")
    public Long addProduct(@RequestBody ProductValidator model){
        return productService.addNewProduct(model);
    }

    @PutMapping("/api/products/{id}")
    public void update(@PathVariable("id") long id,
                       @RequestBody ProductValidator model){
        productService.updateProduct(id,model);
    }

    @DeleteMapping("/api/products/{id}")
    public void delete(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }
}

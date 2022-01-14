package com.WebApi.webapi.controllers;

import com.WebApi.webapi.exceptionsHandlers.ServiceException;
import lombok.AllArgsConstructor;
import com.WebApi.webapi.models.Product;
import com.WebApi.webapi.models.ProductValidator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.WebApi.webapi.services.ProductService;


import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class ProductController {


    private final ProductService productService;


    @GetMapping("/api/products")
    public List<Product> get() throws Exception {
        return  productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public Product get(@PathVariable("id") long id) throws ServiceException {
        return  productService.getProductById(id);
    }

    @PostMapping("/api/products")
    public Long addProduct(@Valid @RequestBody ProductValidator model){
        return productService.addNewProduct(model);
    }

    @PutMapping("/api/products/{id}")
    public void update(@Valid @PathVariable("id") long id,
                       @RequestBody ProductValidator model) throws Exception {
        productService.updateProduct(id,model);
    }

    @DeleteMapping("/api/products/{id}")
    public void delete(@PathVariable("id") long id) throws Throwable {
        productService.deleteProduct(id);
    }
}

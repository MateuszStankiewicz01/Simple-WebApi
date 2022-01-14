package com.WebApi.webapi.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.WebApi.webapi.models.Product;
import com.WebApi.webapi.models.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.WebApi.webapi.repositories.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        log.info("getting all products | ProductService");
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        log.info("getting product by id:"+id+" | ProductService");
        return productRepository.findById(id);
    }

    public Long addNewProduct(ProductValidator model){
        log.info("adding new product | ProductService");
        Product temp = new Product();
        temp.setName(model.getM_name());
        temp.setPrice(model.getM_price());
        return productRepository.saveAndFlush(temp).getId();

    }

    public void updateProduct(long id, ProductValidator model) {
        log.info("updating product by id:"+id+" | ProductService");
        Product product = productRepository.findById(id);
        product.setPrice(model.getM_price());
        product.setName(model.getM_name());
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(long id) {
        log.info("deleting product by id:"+id+" | ProductService");
        productRepository.deleteById(id);
    }
}

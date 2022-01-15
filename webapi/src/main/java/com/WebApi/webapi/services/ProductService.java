package com.WebApi.webapi.services;

import com.WebApi.webapi.exceptionsHandlers.ServiceException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.WebApi.webapi.models.Product;
import com.WebApi.webapi.models.ProductValidator;

import org.springframework.stereotype.Service;
import com.WebApi.webapi.repositories.ProductRepository;



import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProducts() throws Exception {
        List<Product> lst = productRepository.findAll();
        if(lst.size()==0){
            throw new ServiceException("None elements found");
        }
        log.info("getting all products | ProductService");
        return lst;
    }

    public Product getProductById(long id) throws ServiceException {
        log.info("getting product by id: {}| ProductService",id);
        if(productRepository.findById(id)!=null){
            return productRepository.findById(id);
        }
        else{
            throw new ServiceException("Product not found, given id:"+id);
        }

    }

    public long addNewProduct(ProductValidator model){
        log.info("adding new product | ProductService");
        Product temp = new Product(model.getM_name(),model.getM_price());
        return productRepository.saveAndFlush(temp).getId();

    }

    public void updateProduct(long id, ProductValidator model) throws Exception {
        log.info("updating product by id: {} | ProductService",id);
        Product product = productRepository.findById(id);
        if(product == null){
            throw new ServiceException("Product not found, given id:"+id);
        }
        product.setPrice(model.getM_price());
        product.setName(model.getM_name());
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(long id) throws Throwable {
        if(productRepository.findById(id)==null){
            throw new ServiceException("Product not found, given id:"+id);
        }
        log.info("deleting product by id: {} | ProductService",id);
        productRepository.deleteById(id);

    }
}

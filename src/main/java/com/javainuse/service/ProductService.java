package com.javainuse.service;

import com.javainuse.anonation.ServiceAnnonation;
import com.javainuse.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @ServiceAnnonation(value = true)
    public Product createProduct(String name, String code) {
        Product product = new Product(name,code);
        return product;
    }

    public void deleteProduct(String code) {

    }
}

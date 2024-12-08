package com.tanu.service;

import java.util.List;

import com.tanu.entity.Product;

public interface ProductService {
    public boolean saveProduct(Product p);

    public List<Product> getAllProducts();
   
}

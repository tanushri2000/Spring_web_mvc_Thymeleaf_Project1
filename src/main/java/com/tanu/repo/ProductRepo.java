package com.tanu.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tanu.entity.Product;



public interface ProductRepo extends JpaRepository<Product, Integer> {

}
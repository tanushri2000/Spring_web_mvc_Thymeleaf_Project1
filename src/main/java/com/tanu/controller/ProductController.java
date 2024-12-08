package com.tanu.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tanu.entity.Product;
import com.tanu.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class ProductController {
    
    private Logger logger=LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    

    // load form - GET
    @GetMapping("/")
    public ModelAndView loadForm() {
        ModelAndView mav = new ModelAndView();
        
        
        mav.addObject("pobj", new Product());// for form binding
        mav.setViewName("index");
        
        return mav;
    }

    // save product - POST
    @PostMapping("/product")
    public ModelAndView saveProduct(Product pobj) {
        ModelAndView mav = new ModelAndView();
        try {
            
        boolean status = productService.saveProduct(pobj);
        if (status) {
            mav.addObject("smsg", "Product Saved");
        } else {
            mav.addObject("emsg", "Failed to save");
        }
        }catch(Exception e){
            logger.error(e.getMessage());
        }

        mav.addObject("pobj", new Product());// for form binding
        mav.setViewName("index");
        return mav;
    }

    // get products - GET
    @GetMapping("/products")
    public ModelAndView viewProducts() {
        List<Product> productsList = productService.getAllProducts();
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("plist", productsList);
        mav.setViewName("data");

        return mav;
    }
}
package com.kubeiko.Product.controller;

import com.kubeiko.Product.model.Product;
import com.kubeiko.Product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServiceImpl productServiceImpl;
    @PostMapping
    @RequestMapping("/save")

    public Product save(@RequestBody Product product){
        Product response = productServiceImpl.save(product);


        return response;
    }
    @GetMapping
    @RequestMapping("/find")

    public Product find(@RequestParam Long id){

        return productServiceImpl.find(id);
    }
}

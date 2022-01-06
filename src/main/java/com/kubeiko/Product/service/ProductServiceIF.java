package com.kubeiko.Product.service;

import com.kubeiko.Product.model.Product;

public interface ProductServiceIF {
    public Product save(Product product);
    public Product find(Long id);
}

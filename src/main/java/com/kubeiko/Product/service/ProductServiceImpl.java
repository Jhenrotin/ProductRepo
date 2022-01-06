package com.kubeiko.Product.service;

import com.kubeiko.Product.dao.ProductDao;
import com.kubeiko.Product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductServiceIF{
    @Autowired
    ProductDao productDao;
    @Override
    public Product save(Product product) {
        Product response = new Product();

        boolean isDataValid = validate(product);

        if(isDataValid == false){
            response.setMessage("Please provide all required fields.");
        }

        else {
            response = productDao.save(product);
        }

        return response;
    }
    @Override
    public Product find(Long id){

        return productDao.find(id);



    }

    public boolean validate(Product product){
        if (product.getProductBrand()==null){
            return false;
        }
        else if(product.getMftrDate()==null){
            return false;
        }
        else if(product.getPrice()==0){
            return false;
        }
        else if(product.getExpDate()==null){
            return false;
        }
        else {return true;}

    }
}
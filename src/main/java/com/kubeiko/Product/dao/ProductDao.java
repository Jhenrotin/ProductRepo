package com.kubeiko.Product.dao;

import com.kubeiko.Product.dto.ProductDTO;
import com.kubeiko.Product.model.Product;
import com.kubeiko.Product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductDao {
    @Autowired
    ProductRepo productRepo;

    public Product save(Product product){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductBrand(product.getProductBrand());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductWeight(product.getProductWeight());
        productDTO.setMftrDate(product.getMftrDate());
        productDTO.setPrice(product.getPrice());
        productDTO.setExpDate(product.getExpDate());

        ProductDTO entity = productRepo.save(productDTO);

        Product response = new Product();

        response.setId(entity.getId());
        response.setProductBrand(entity.getProductBrand());
        response.setProductName(entity.getProductName());
        response.setProductWeight(entity.getProductWeight());
        response.setMftrDate(entity.getMftrDate());
        response.setPrice(entity.getPrice());
        response.setExpDate(entity.getExpDate());
        return response;


    }
    public Product find(Long id){
        Optional<ProductDTO> optional = productRepo.findById(id);
        if (optional.isPresent()){
            ProductDTO entity = optional.get();
            Product response = new Product();

            response.setId(entity.getId());
            response.setProductBrand(entity.getProductBrand());
            response.setProductName(entity.getProductName());
            response.setProductWeight(entity.getProductWeight());
            response.setMftrDate(entity.getMftrDate());
            response.setPrice(entity.getPrice());
            response.setExpDate(entity.getExpDate());

            return response;
        }
        else{
            return null;
        }

    }
}

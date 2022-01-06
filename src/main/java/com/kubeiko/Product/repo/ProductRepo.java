package com.kubeiko.Product.repo;

import com.kubeiko.Product.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDTO,Long> {

}

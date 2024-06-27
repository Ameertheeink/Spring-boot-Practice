package com.example.jdbc.service;

import com.example.jdbc.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Repository
public interface ProductService {
    List<Product> getProduct();
    void CreateProduct(Product product);
    void UpdateProduct(Integer id, Product product);
    void DeleteProduct(Integer id);

}

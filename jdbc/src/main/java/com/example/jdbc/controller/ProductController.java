package com.example.jdbc.controller;

import com.example.jdbc.model.Product;
import com.example.jdbc.service.ProductService;
import com.example.jdbc.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allproducts")
    List<Product> getAllProducts() {
        return productService.getProduct();
    }

    @PostMapping("/addproduct")
    void insert(@RequestBody Product product) {
        productService.CreateProduct(product);
    }

    @PutMapping("/editproduct/{id}")
    void updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productService.UpdateProduct(id, product);
    }
@DeleteMapping("/deleteproduct/{id}")
    String delete(@PathVariable Integer id) {

        productService.DeleteProduct(id);
        return "Deleted Successfully";
    }
}

package com.example.jdbc.service.impl;

import com.example.jdbc.model.Product;
import com.example.jdbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    RowMapper rowMapper=(rs,rowNum)->new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getDouble("price"),
            rs.getInt("quantity")

    );
    @Override
    public List<Product> getProduct() {
        var sql="select * from product";
        return jdbcTemplate.query(sql,rowMapper);

    }

    @Override
    public void CreateProduct(Product product) {
        var sql="insert into product(id,name,price,quantity) values(?,?,?,?)";
        jdbcTemplate.update(sql,product.getId(),product.getName(),product.getPrice(),product.getQuantity());


    }

    @Override
    public void UpdateProduct(Integer id, Product product) {
var sql="update product set name=?,price=?,quantity=? where id=?";
jdbcTemplate.update(sql,product.getName(),product.getPrice(),product.getQuantity(),id);
    }

    @Override
    public void DeleteProduct(Integer id) {
var sql="delete from product where id=?";
jdbcTemplate.update(sql,id);
    }
}

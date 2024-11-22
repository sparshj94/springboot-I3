package com.example.SpringBootProduct.service;

import com.example.SpringBootProduct.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public int saveProduct(Product product);

    public List<Product> getAllProducts();

    public void deleteProduct(int id);

    public  Product getProductById(int id);

    public void updateProduct(Product product);

}

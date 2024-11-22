package com.example.SpringBootProduct.service;

import com.example.SpringBootProduct.models.Product;
import com.example.SpringBootProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplement implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public  int saveProduct(Product product) {
        Double price = product.getPrice();
        product.setGst(price*0.18);
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> list = productRepository.findAll();
        return  list;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }


}

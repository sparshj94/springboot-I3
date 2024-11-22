package com.example.SpringBootProduct.controller;


import com.example.SpringBootProduct.models.Product;
import com.example.SpringBootProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/register")
    public String showRegister() {
        return "ProductRegister";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product prod, Model model) {
        int id = productService.saveProduct(prod);
        String data = "Product saved with id: " + id;
        model.addAttribute("Message",data);
        return "ProductRegister";
    }

    @GetMapping("/all")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "ProductData";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product/all";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "ProductUpdate";
    }


    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.updateProduct(product);
        return "redirect:/product/all";
    }







}

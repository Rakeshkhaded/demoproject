package com.example.demoproject.Controller;

import com.example.demoproject.Entity.Product;
import com.example.demoproject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProduct(){

        return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){

        return service.getProductById(prodId);

    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product prod){

        service.addProduct(prod);
    }
}

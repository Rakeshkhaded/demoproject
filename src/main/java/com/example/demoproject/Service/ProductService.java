package com.example.demoproject.Service;

import com.example.demoproject.Entity.Product;
import com.example.demoproject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo prodrepo;

   // List<Product> list = new ArrayList<>(Arrays.asList(new Product(100,"mobile",65000)));

    public List<Product> getProducts(){

       // return list;
        return prodrepo.findAll();
    }

    public Product getProductById(int prodId) {

        return prodrepo.findById(prodId).get();
    }

    public void addProduct(Product prod) {

        prodrepo.save(prod);
    }
}

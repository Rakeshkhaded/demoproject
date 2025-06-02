package com.example.demoproject.Service;

import com.example.demoproject.Entity.Product;
import com.example.demoproject.Error.ProductNotFoundException;
import com.example.demoproject.Inventory.InventoryClient;
import com.example.demoproject.Inventory.InventoryResponse;
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

    @Autowired
    InventoryClient inventoryclient;

   // List<Product> list = new ArrayList<>(Arrays.asList(new Product(100,"mobile",65000)));

    public List<Product> getProducts(){

       // return list;
        return prodrepo.findAll();
    }

    public Product getProductById(int prodId) throws ProductNotFoundException {

        Product product =prodrepo.findById(prodId).orElseThrow(()-> new ProductNotFoundException("Product is not available"));

        InventoryResponse inventresponse = inventoryclient.getInventoryByProductId(prodId);
        System.out.println("Quantiy of the product id is: "+prodId+" "+inventresponse.getAvailableQuantity());

        return product;
    }

    public void addProduct(Product prod) {

        prodrepo.save(prod);
    }

    public void updateProduct(Product prod) {

        prodrepo.save(prod);
    }

    public void deleteProductById(int prodId) {

        prodrepo.deleteById(prodId);

    }

}

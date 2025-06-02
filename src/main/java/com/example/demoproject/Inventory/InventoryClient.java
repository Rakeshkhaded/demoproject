package com.example.demoproject.Inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Inventory-service", url="http://localhost:8081")
public interface InventoryClient {

    @GetMapping("/inventory/{prodId}")
    public InventoryResponse getInventoryByProductId(@PathVariable int prodId);


}

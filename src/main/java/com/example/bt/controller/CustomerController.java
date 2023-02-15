package com.example.bt.controller;

import com.example.bt.model.Order;
import com.example.bt.model.Product;
import com.example.bt.model.Shop;
import com.example.bt.model.request.ProductRequest;
import com.example.bt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customer/get-all-shop")
    public ResponseEntity<List<Shop>> getAllShop(){
        return ResponseEntity.ok(customerService.showListShop());
    }

    @GetMapping(value = "/customer/{id-shop}/get-all-product")
    public ResponseEntity<List<Product>> getAllProduct(@PathVariable(name = "id-shop") int idShop){
        return ResponseEntity.ok(customerService.showListProductInShop(idShop));
    }

    @PostMapping(value = "/customer/{id-shop}/get-order")
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id-shop") int idShop,
                                          @RequestParam int idCustomer,
                                          @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(customerService.getOrder(idShop,idCustomer,productRequest.getNameProducts()));
    }
}

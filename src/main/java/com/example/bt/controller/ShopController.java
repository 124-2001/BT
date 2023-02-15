package com.example.bt.controller;

import com.example.bt.model.Order;
import com.example.bt.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    ShopService shopServicel;
    @GetMapping("/shop/get-order-waiting")
    public ResponseEntity<List<Order>> getOrderWaiting(@RequestParam int idShop){
        return ResponseEntity.ok(shopServicel.showListOrderWaiting(idShop));
    }
    @PostMapping(value = "/shop/change-status")
    public ResponseEntity<?> acceptOrderWaiting(@RequestParam int idOrder){
        return ResponseEntity.ok(shopServicel.changeStatusOrder(idOrder));
    }
}

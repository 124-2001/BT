package com.example.bt.service;

import com.example.bt.model.Order;
import com.example.bt.model.enumEntity.Status;
import com.example.bt.repository.OrderRepository;
import com.example.bt.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopService {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    OrderRepository orderRepository;
    //idShop thay authenticate, tim nhung don chua xac nhan voi customer
    public List<Order> showListOrderWaiting(int idShop){
        return orderRepository.findByShop_orderAndStatus(shopRepository.findById(idShop).get(), Status.WAITING);
    }
    //tim trong list don pic 1 id bat ki
    public Order changeStatusOrder(int idOrder){
       Order order = orderRepository.findById(idOrder).get();
       order.setStatus(Status.OK);
       orderRepository.save(order);
       return order;
    }
}

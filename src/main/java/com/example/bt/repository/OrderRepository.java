package com.example.bt.repository;

import com.example.bt.model.Order;
import com.example.bt.model.Shop;
import com.example.bt.model.enumEntity.Status;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByShop_orderAndStatus(Shop shop, Status status);
}

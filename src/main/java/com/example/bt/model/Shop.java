package com.example.bt.model;

import com.example.bt.model.enumEntity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy = "shop_order")
    private List<Order> orders;
    @OneToMany(mappedBy = "shop_product")
    private List<Product> products;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    private Status status;
}

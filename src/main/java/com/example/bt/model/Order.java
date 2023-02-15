package com.example.bt.model;


import com.example.bt.model.enumEntity.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(mappedBy = "orders")
    private List<Product> products;
    private Status status;
    @ManyToOne()
    @JoinColumn(name = "order_product_id")
    private Customer customer;

    @ManyToOne()
    @JoinColumn(name = "order_shop_id")
    private Shop shop_order;

    private double total;


}

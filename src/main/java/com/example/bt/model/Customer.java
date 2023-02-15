package com.example.bt.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}

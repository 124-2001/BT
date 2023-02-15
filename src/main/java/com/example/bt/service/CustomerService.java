package com.example.bt.service;

import com.example.bt.model.Order;
import com.example.bt.model.Product;
import com.example.bt.model.Shop;
import com.example.bt.model.Wallet;
import com.example.bt.model.enumEntity.Status;
import com.example.bt.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    ProductRepository productRepository;

    public List<Shop> showListShop(){
        return shopRepository.findAll();
    }

    public List<Product> showListProductInShop(int idShop){
        Shop shop = shopRepository.findById(idShop).get();
        return shop.getProducts();
    }
    //He thong ban hang online
    //idShop tim trong List Shop, idCustomer thay cho Authenticate
    public Order getOrder(int idShop,int idCustomer,List<String> nameProducts){
        Order order = new Order();
        order.setShop_order(shopRepository.findById(idShop).get());
        order.setCustomer(customerRepository.findById(idCustomer).get());
        /*List<Product> products = showListProductInShop(idShop);*/
        for (String nameProduct : nameProducts) {
            if(productRepository.findByName(nameProduct).isPresent()){
                order.getProducts().add(productRepository.findByName(nameProduct).get());
            }
        }
        order.setTotal(getTotalInOrder(order.getProducts()));
        order.setStatus(Status.WAITING);
        orderRepository.save(order);
        Wallet wallet = customerRepository.findById(idCustomer).get().getWallet();
        if(wallet.getBalance()>getTotalInOrder(order.getProducts())){
            wallet.setBalance(wallet.getBalance()-order.getTotal());
        }
        else {
            return null;
        }
        walletRepository.save(wallet);
        return order;
    }

    public  double getTotalInOrder(List<Product> products){
        double total=0;
        for (Product product : products) {
            total+=product.getPrice();
        }
        return total;
    }
}

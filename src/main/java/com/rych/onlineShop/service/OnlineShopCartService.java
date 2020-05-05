package com.rych.onlineShop.service;

import com.rych.onlineShop.model.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OnlineShopCartService {
    private final static int LOWER_BOUND = 50;
    private final static int UPPER_BOUND = 300;
    private final static int SCALE = 2;

    private List<Product> productList;

    public OnlineShopCartService() {
        Product product1 = new Product("Phone", generatedPrice());
        Product product2 = new Product("Tablet", generatedPrice());
        Product product3 = new Product("TV", generatedPrice());
        Product product4 = new Product("Game", generatedPrice());
        Product product5 = new Product("Controller", generatedPrice());
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    public BigDecimal generatedPrice() {
        Random r = new Random();
        int randomInt = r.nextInt((UPPER_BOUND - LOWER_BOUND) * 100) + LOWER_BOUND;
        return new BigDecimal(BigInteger.valueOf(randomInt), SCALE);
    }

    //po co te getery i setery??
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public BigDecimal getTotalPrice(OnlineShopCartService onlineShopCartService) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Product p : onlineShopCartService.getProductList()) {
            totalPrice = totalPrice.add(p.getPrice());
        }
        return totalPrice;
    }


    //czy to potrzegne a moze przeniesc
    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        productList.forEach(System.out::println);
    }
}

package com.rych.onlineShop.service;

import com.rych.onlineShop.config.MembershipConfig;
import controller.CartPlus;
import controller.CartPro;
import controller.CartStart;
import controller.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OnlineShopCartService {

    private MembershipConfig membershipConfig;

    @Autowired
    public OnlineShopCartService(MembershipConfig membershipConfig) {
        this.membershipConfig = membershipConfig;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void start() {
        CartPlus cartPlus = new CartPlus(membershipConfig, ProductUtils.getRandomFiveProducts());
        CartPro cartPro = new CartPro(membershipConfig, ProductUtils.getRandomFiveProducts());
        CartStart cartStart = new CartStart(membershipConfig, ProductUtils.getRandomFiveProducts());

        cartPlus.getProducts().forEach(System.out::println);
        cartPro.getProducts().forEach(System.out::println);
        cartStart.getProducts().forEach(System.out::println);

        System.out.println("CartPlus sum price: " + cartPlus.getPriceOfProducts());
        System.out.println("CartPro sum price: " + cartPro.getPriceOfProducts());
        System.out.println("CartStart sum price: " + cartStart.getPriceOfProducts());

    }
}

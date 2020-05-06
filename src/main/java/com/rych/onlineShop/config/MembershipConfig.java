package com.rych.onlineShop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MembershipConfig {

    @Value("${cart.plus.discount}")
    private Double cartPlusDiscount;
    @Value("${cart.plus.vat}")
    private Double cartPlusVat;
    @Value("${cart.pro.discount}")
    private Double cartProDiscount;
    @Value("${cart.pro.vat}")
    private Double cartProVat;
    @Value("${cart.start.discount}")
    private Double cartStartDiscount;
    @Value("${cart.start.vat}")
    private Double cartStartVat;


    public BigDecimal getCartPlusDiscount() {
        return BigDecimal.valueOf(cartPlusDiscount);
    }

    public BigDecimal getCartPlusVat() {
        return BigDecimal.valueOf(cartPlusVat);
    }

    public BigDecimal getCartProDiscount() {
        return BigDecimal.valueOf(cartProDiscount);
    }

    public BigDecimal getCartProVat() {
        return BigDecimal.valueOf(cartProVat);
    }

    public BigDecimal getCartStartDiscount() {
        return BigDecimal.valueOf(cartStartDiscount);
    }

    public BigDecimal getCartStartVat() {
        return BigDecimal.valueOf(cartStartVat);
    }

}

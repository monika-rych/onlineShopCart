package controller;

import java.math.BigDecimal;

public abstract class Cart {

    abstract BigDecimal getVat();

    abstract BigDecimal getDiscount();

    abstract BigDecimal getPriceOfProducts();

}

package controller;

import com.rych.onlineShop.model.Product;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ProductUtils {

    private final int MAX = 300;
    private final int MIN = 50;

    BigDecimal getRandomPrice() {
        return BigDecimal.valueOf((Math.random() * ((MAX - MIN) + 1)) + MIN);
    }

    public List<Product> getRandomFiveProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("1", getRandomPrice()));
        productList.add(new Product("2", getRandomPrice()));
        productList.add(new Product("3", getRandomPrice()));
        productList.add(new Product("4", getRandomPrice()));
        productList.add(new Product("5", getRandomPrice()));
        return productList;
    }
}

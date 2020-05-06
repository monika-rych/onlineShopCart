package controller;

import com.rych.onlineShop.config.MembershipConfig;
import com.rych.onlineShop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CartStart extends Cart {

    private final MembershipConfig membershipConfig;
    private List<Product> products = new ArrayList<>();


    @Override
    BigDecimal getVat() {
        return membershipConfig.getCartStartVat();
    }

    @Override
    BigDecimal getDiscount() {
        return membershipConfig.getCartStartDiscount();
    }

    @Override

    public BigDecimal getPriceOfProducts() {
        BigDecimal sum = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return sum;
    }
}

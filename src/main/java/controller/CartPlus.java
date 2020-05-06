package controller;

import com.rych.onlineShop.config.MembershipConfig;
import com.rych.onlineShop.model.Product;
import com.rych.onlineShop.service.OnlineShopCartService;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class CartPlus extends Cart {

    private final MembershipConfig membershipConfig;
    private List<Product> products = new ArrayList<>();

    @Override
    BigDecimal getVat() {
        return membershipConfig.getCartPlusVat();
    }

    @Override
    BigDecimal getDiscount() {
        return membershipConfig.getCartPlusDiscount();
    }

    @Override
    public BigDecimal getPriceOfProducts() {
        BigDecimal sum = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        return sum.multiply(getVat());
    }
}

package controller;

import com.rych.onlineShop.service.OnlineShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("Start")
public class CartStart {

    @Value("${value.membership}")
    private String membership;

    @Value("${value.VAT}")
    private BigDecimal vat;

    @Value("${value.discount}")
    private BigDecimal discount;

    private OnlineShopCartService onlineShopCartService;

    @Autowired
    public CartStart(OnlineShopCartService onlineShopCartService) {
        this.onlineShopCartService = onlineShopCartService;
    }

//    @Override
//    public BigDecimal getSumPrice() {
//        return getTotalPrice(shoppingCartService);
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    @Override
//    public void showShoppingCart() {
//        System.out.println("Membership: " + membership);
//        System.out.println("Your shopping cart contain: ");
//        for ( Product product :shoppingCartService.getShoppingCart()) {
//            System.out.println(product.getName() + " - " + product.getPrice() + " PLN");
//        }
//        System.out.println("PRO membership discout: " + discount + "%");
//        System.out.println("Base price: " + getSumPrice() + " PLN");
//        System.out.println("Your price after discount: " +  getSumPrice().subtract(getSumPrice().multiply(discount.divide(BigDecimal.valueOf(100))))
//                .setScale(2,RoundingMode.CEILING) + " PLN");
//        System.out.println("VAT: " + getSumPrice().multiply(vat).setScale(2, RoundingMode.CEILING) + " PLN");
//
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void get(){
//        System.out.println(pack);
//        System.out.println(discount);
}

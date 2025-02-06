package org.skypro.skyshop1.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Component
@SessionScope
public class ProductBasket {

    private final Map<UUID, Integer> products = new HashMap<>();

    public void addProduct(UUID productId) {
        products.put(productId, products.getOrDefault(productId, 0) + 1);
    }

    public void removeProduct(UUID productId) {
        if (products.containsKey(productId)) {
            int count = products.get(productId);
            if (count > 1) {
                products.put(productId, count - 1);
            } else {
                products.remove(productId);
            }
        }
    }



    public Map<UUID, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}

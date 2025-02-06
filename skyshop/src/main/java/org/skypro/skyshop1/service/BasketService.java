package org.skypro.skyshop1.service;

import org.skypro.skyshop1.exception.NoSuchProductException;
import org.skypro.skyshop1.model.basket.ProductBasket;
import org.skypro.skyshop1.model.product.Product;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID productId) {
        try {
            Product product = storageService.getProductById(productId);
            productBasket.addProduct(productId);
        } catch (NoSuchProductException e) {
            throw new NoSuchProductException("Product with ID " + productId + " not found.", e);
        }
    }

    public UserBasket getUserBasket() {
        List<BasketItem> basketItems = productBasket.getProducts().entrySet().stream()
                .map(entry -> new BasketItem(storageService.getProductById(entry.getKey()), entry.getValue()))
                .collect(Collectors.toList());

        return new UserBasket(basketItems);
    }
}

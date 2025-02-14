package org.skypro.skyshop1.test;

import org.junit.jupiter.api.Test;
import org.skypro.skyshop1.Application;
import org.skypro.skyshop1.model.basket.ProductBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)


public class ProductBasketTest {
    @Autowired
    private ProductBasket productBasket;

    @Test
    public void testAddProduct() {
        UUID productId = UUID.randomUUID();

        productBasket.addProduct(productId);

        assertEquals(1,productBasket.getProducts().getOrDefault(productId, 0));

        productBasket.removeProduct(UUID.randomUUID());

        assertEquals(1, productBasket.getProducts().getOrDefault(productId, 0));
    }

    @Test
    public void testGetProducts() {
        UUID productId = UUID.randomUUID();

        productBasket.addProduct(productId);

        assertTrue(productBasket.getProducts().containsKey(productId));
    }
    @Test
    public void testRemoveProduct() {
        UUID productId = UUID.randomUUID();

        productBasket.addProduct(productId);
        productBasket.removeProduct(productId);

        assertFalse(productBasket.getProducts().containsKey(productId));
    }

    @Test
    public void testEmptyBasket() {
        assertTrue(productBasket.getProducts().isEmpty());
    }

}
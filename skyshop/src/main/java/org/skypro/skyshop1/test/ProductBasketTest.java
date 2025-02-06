package org.skypro.skyshop1.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skypro.skyshop1.Application;
import org.skypro.skyshop1.model.basket.ProductBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
}

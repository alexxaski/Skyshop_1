package org.skypro.skyshop1.controller;

import org.skypro.skyshop1.model.search.SearchResult;
import org.skypro.skyshop1.service.BasketService;
import org.skypro.skyshop1.service.SearchService;
import org.skypro.skyshop1.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.article.Article;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService productBasketService;

    public ShopController(StorageService storageService, SearchService searchService,BasketService productBasketService) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.productBasketService = productBasketService;
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public Set<SearchResult> search(String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public String addProductToBasket(@PathVariable("id") UUID id) {
        productBasketService.addProductToBasket(id);
        return "Продукт успешно добавлен";
    }

    @GetMapping("/basket")
    public Map<UUID, Integer> getUserBasket() {
        return (Map<UUID, Integer>) productBasketService.getUserBasket();
    }
}


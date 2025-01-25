package org.skypro.skyshop1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.skypro.skyshop1.controller.model.product.Product;
import org.skypro.skyshop1.controller.model.article.Article;
import org.skypro.skyshop1.controller.service.StorageService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
public class ShopController {

    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles() {
        return storageService.getArticles();
    }

    @JsonIgnore
    public String getSearchTerm() {

        return null;
    }

    @JsonIgnore
    public String getContentType() {

        return null;
    }
}


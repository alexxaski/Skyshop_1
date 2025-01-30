package org.skypro.skyshop1.service;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import org.skypro.skyshop1.model.article.Article;
import org.skypro.skyshop1.model.product.FixPriceProduct;
import org.skypro.skyshop1.model.product.DiscountedProduct;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.product.SimpleProduct;
import org.skypro.skyshop1.model.search.Searchable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;


@Service
public class StorageService {

    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        addProduct(new SimpleProduct(UUID.randomUUID(), "Творог", 120));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Сметана", 98, 20));
        addProduct(new FixPriceProduct(UUID.randomUUID(), "крем"));
        addProduct(new SimpleProduct(UUID.randomUUID(), "Варенье вишневое", 75));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Пирог с малиной", 300, 20));

        this.articles = new HashMap<>();
        addArticle(new Article(UUID.randomUUID(), "Омлет с ветчиной", "Приготовлен из яиц и ветчины."));
        addArticle(new Article(UUID.randomUUID(), "Заголовок", "Текст"));
        addArticle(new Article(UUID.randomUUID(), "Статья про баклажаны", "Описание баклажанов"));
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    public void addProduct(Product product) {
        UUID id = product.getID();
        String productName = product.getProductName();
        int price = product.getPrice();
        products.put(id, product);
    }

    public void addArticle(Article article) {
        UUID id = article.getID();
        String title = article.getTitle();
        String texst = article.getTexst();
        articles.put(id, article);
    }

    public Set<Searchable> getSearchableCollection() {
        Set<Searchable> searchList = new HashSet<>();
        searchList.addAll(products.values());
        searchList.addAll(articles.values());
        return searchList;
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));

    }
}


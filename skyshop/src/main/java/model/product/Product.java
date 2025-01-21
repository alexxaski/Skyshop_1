package org.skypro.skyshop.product;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;
import java.util.Objects;


public abstract class Product implements Searchable{
    public final String productName ;
    public abstract class Product implements Searchable {
        public final String productName;


        public Product(String productName) {
            if (productName == null || productName.isBlank()) {
                throw new IllegalArgumentException("Название продукта не может быть пустым или содержать только пробелы.");
            }
            this.productName = productName;
        }

        public String getProductName() {
            return productName;
        }

        public abstract int getPrice();

        public abstract boolean isSpecial();

        @Override
        public String toString() {
            return productName + '=' + getPrice();
        }

        @Override
        public String getSearchTerm() {
            return productName;
        }

        @Override
        public String getContentType() {
            return "PRODUCT";
        }

        @Override
        public String getObjectName() {
            return productName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(productName, product.productName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productName);
        }
    }

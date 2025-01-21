package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice; // Базовая цена
    private int discountPercentage; // Скидка в процентах

    public DiscountedProduct(String productName, int basePrice, int discountPercentage) {
        super(productName);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0.");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть числом в диапазоне от 0 до 100 включительно.");
        }
        this.basePrice = basePrice;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getPrice() {

        return basePrice - (basePrice * discountPercentage / 100);
    }
    @Override
    public boolean isSpecial() {
        return true; // Простой товар не является специальным
    }
    @Override
    public String toString() {
        return productName + ": " + getPrice();
    }
}

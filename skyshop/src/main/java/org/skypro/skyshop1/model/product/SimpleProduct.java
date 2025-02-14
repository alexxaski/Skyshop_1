package org.skypro.skyshop1.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(UUID id, String productName, int price) {
        super(id, productName);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0.");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getObjName() {
        return "Название объекта";
    }

    @Override
    public UUID getID() {
        return this.id;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Object getName() {
        return getName();
    }
}
package org.skypro.skyshop1.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 50;

    public FixPriceProduct(UUID id, String productName) {
        super(id,productName);

    }
    @Override
    public int getPrice () {
        return FIXED_PRICE;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getObjName() {
        return this.productName;
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

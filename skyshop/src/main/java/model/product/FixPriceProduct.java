package org.skypro.skyshop.product;


class FixPriceProduct extends Product {

    private static final int FIXED_PRICE = 50;

    public FixPriceProduct(String productName) {
        super(productName);
    }
    @Override
    public int getPrice () {
        return FIXED_PRICE;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}

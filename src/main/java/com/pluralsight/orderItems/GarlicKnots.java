package com.pluralsight.orderItems;

import com.pluralsight.abstracts.OrderItem;

public class GarlicKnots extends OrderItem {
    private static final double price = 1.50;

    public GarlicKnots(int quantity) {
        super(quantity);
    }

    @Override
    public double getPrice() {
        return quantity * price;
    }

    @Override
    public String getDescription() {
        return String.format("Garlic Knots - x%d - $%.2f", quantity, getPrice());
    }
}

package com.pluralsight.toppings;

import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.Size;

public class Cheese extends Topping {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {
        double basePrice = switch (size) {
            case PERSONAL -> 0.75;
            case MEDIUM -> 1.50;
            case LARGE -> 2.25;
        };
        double extraPrice = switch (size) {
            case PERSONAL -> 0.30;
            case MEDIUM -> 0.60;
            case LARGE -> 0.90;
        };
        return isExtra ? basePrice + extraPrice : basePrice;
    }

    @Override
    public String getDescription() {
        return (isExtra ? "Extra " : "") + name;
    }
}
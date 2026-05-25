package com.pluralsight.toppings;

import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.Size;

public class Meat extends Topping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {
        double basePrice = switch (size) {
            case PERSONAL -> 1.00;
            case MEDIUM -> 2.00;
            case LARGE -> 3.00;
        };
        double extraPrice = switch (size) {
            case PERSONAL -> 0.50;
            case MEDIUM -> 1.00;
            case LARGE -> 1.50;
        };
        return isExtra ? extraPrice + basePrice : basePrice;
    }

    @Override
    public String getDescription() {
        return (isExtra ? "Extra " : "") + name;
    }
}
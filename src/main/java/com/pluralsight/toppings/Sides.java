package com.pluralsight.toppings;

import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.Size;

public class Sides extends Topping {
    public Sides(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(Size size) {   return 0.00;    }

    @Override
    public String getDescription() {    return name + " (side)";   }
}

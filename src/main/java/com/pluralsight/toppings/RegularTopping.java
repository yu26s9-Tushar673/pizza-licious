package com.pluralsight.toppings;

import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.Size;

public class RegularTopping extends Topping {

    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {    return 0.00;    }

    @Override
    public String getDescription() {    return name;    }
}

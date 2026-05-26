package com.pluralsight.toppings;

import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.Size;

public class Sauce extends Topping {
    public Sauce(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(Size size) {    return 0.00;    }

    @Override
    public String getDescription() {
        if (isExtra){
            return "Extra " + name + " sauce";
        } else {
            return name + " sauce";
        }
    }
}
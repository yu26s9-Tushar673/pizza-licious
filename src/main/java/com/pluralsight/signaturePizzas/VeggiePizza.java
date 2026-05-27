package com.pluralsight.signaturePizzas;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.Size;
import com.pluralsight.orderItems.Pizza;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.RegularTopping;
import com.pluralsight.toppings.Sauce;

public class VeggiePizza extends Pizza {
    public VeggiePizza() {
        super(Size.PERSONAL, CrustType.REGULAR, false);
        addToppings(new RegularTopping("Bell Peppers", false));
        addToppings(new RegularTopping("Spinach", false));
        addToppings(new RegularTopping("Olives", false));
        addToppings(new RegularTopping("Onions", false));
        addToppings(new Cheese("Mozzarella", false));
        addToppings(new Sauce("Marinara", false));
    }
}

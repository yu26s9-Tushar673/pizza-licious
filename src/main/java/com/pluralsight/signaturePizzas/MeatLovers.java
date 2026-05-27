package com.pluralsight.signaturePizzas;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.Size;
import com.pluralsight.orderItems.Pizza;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.Sauce;

public class MeatLovers extends Pizza {
    public MeatLovers() {
        super(Size.LARGE, CrustType.REGULAR, false);
        addToppings(new Meat("Pepperoni", false));
        addToppings(new Meat("Chicken", false));
        addToppings(new Meat("Sausage", false));
        addToppings(new Meat("Bacon", false));
        addToppings(new Cheese("Mozzarella", false));
    }
}

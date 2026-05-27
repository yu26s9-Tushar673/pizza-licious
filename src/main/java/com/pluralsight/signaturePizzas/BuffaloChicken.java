package com.pluralsight.signaturePizzas;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.Size;
import com.pluralsight.orderItems.Pizza;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.Sauce;

public class BuffaloChicken extends Pizza {

    public BuffaloChicken() {
        super(Size.MEDIUM, CrustType.REGULAR, false);
        addToppings(new Sauce("Buffalo", false));
        addToppings(new Meat("Chicken", false));
        addToppings(new Cheese("Mozzarella", false));
    }
}

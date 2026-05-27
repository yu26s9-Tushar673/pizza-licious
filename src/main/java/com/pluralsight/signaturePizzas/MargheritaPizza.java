package com.pluralsight.signaturePizzas;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.Size;
import com.pluralsight.orderItems.Pizza;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.RegularTopping;
import com.pluralsight.toppings.Sauce;

public class MargheritaPizza extends Pizza {
    public MargheritaPizza() {
        super(Size.MEDIUM, CrustType.REGULAR, false);
        addToppings(new Cheese("Mozzarella", false));
        addToppings(new RegularTopping("Tomatoes", false));
        addToppings(new RegularTopping("Basil", false));
        addToppings(new Sauce("Marinara", false));
        addToppings(new Sauce("Olive Oil", false));
    }


}

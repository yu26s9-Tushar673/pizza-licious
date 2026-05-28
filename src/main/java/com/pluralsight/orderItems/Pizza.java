package com.pluralsight.orderItems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.abstracts.Topping;
import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.Size;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends OrderItem {
    private Size size;
    private CrustType crustType;
    private List<Topping> toppings;
    private boolean isStuffedCrust;

    public Pizza(Size size, CrustType crust, boolean isStuffedCrust) {
        super(1);
        this.size = size;
        this.crustType = crust;
        this.isStuffedCrust = isStuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public void addToppings(Topping topping) {    toppings.add(topping);    }
    public void removeTopping(int index) {    toppings.remove(index);    }

    @Override
    public double getPrice() {
        double total = size.getBasePrice();
        if (isStuffedCrust) {
            total += switch (size) {
                case PERSONAL -> 1.00;
                case MEDIUM -> 1.50;
                case LARGE -> 2.00;
            };
        }
        for (Topping t : toppings){
            total += t.getPrice(size);
        }
        return total;
    }

    @Override
    public String getDescription() {
        StringBuilder order = new StringBuilder();
        order.append(String.format("Pizza - %s, %s, crust%s - $%.2f%n",
                size, crustType, isStuffedCrust ? ", Stuffed" : "", getPrice()));
        for (Topping t: toppings) {
            order.append(String.format("   + %-25s $%.2f%n", t.getDescription(), t.getPrice(size)));
        }
        return order.toString();
    }

    // Getters
    public Size getSize() {    return size;    }
    public CrustType getCrustType() {   return crustType;   }
    public List<Topping> getToppings() {    return toppings;    }
    public boolean isStuffedCrust() {   return isStuffedCrust;  }
}
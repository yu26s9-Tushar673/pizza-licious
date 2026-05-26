package com.pluralsight.orderItems;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.enums.DrinkSize;

public class Drink extends OrderItem {
    private DrinkSize drinkSize;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        super(1);
        this.drinkSize = size;
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {     return drinkSize.getPrice();    }

    @Override
    public String getDescription() {
        return String.format("Drink - %s, %s - $%.2f", drinkSize, flavor, drinkSize.getPrice());
    }

    // Getters
    public DrinkSize getDrinkSize() {   return drinkSize;   }
    public String getFlavor() {  return flavor;  }
}
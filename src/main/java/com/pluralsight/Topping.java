package com.pluralsight;

import com.pluralsight.enums.Size;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    // Constructor
    public Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    // Abstract Methods
    public abstract double getPrice(Size size);
    public abstract String getDescription();

    // Getter and Setters
    public String getName() {   return name;   }
    public boolean isExtra() {   return isExtra;   }
    public void setExtra(boolean extra) {   isExtra = extra;   }
}

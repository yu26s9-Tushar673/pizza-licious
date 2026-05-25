package com.pluralsight.enums;

public enum Size {

    PERSONAL(8.50),
    MEDIUM(12.00),
    LARGE(16.50);

    private final double basePrice;

    // Enum Constructor
    Size(double basePrice) {    this.basePrice = basePrice;    }

    // Getter
    public double getBasePrice() {   return basePrice;   }
}

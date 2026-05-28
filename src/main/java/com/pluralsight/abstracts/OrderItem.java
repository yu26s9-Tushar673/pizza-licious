package com.pluralsight.abstracts;

public abstract class OrderItem {
    protected int quantity;

    public OrderItem(int quantity){
        this.quantity = quantity;
    }

    // Abstract Methods
    public abstract double getPrice();
    public abstract String getDescription();

    // Getter and Setter
    public int getQuantity() {    return quantity;    }
    public void setQuantity(int quantity) {    this.quantity = quantity;   }
}
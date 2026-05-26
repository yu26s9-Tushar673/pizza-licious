package com.pluralsight.main;

import com.pluralsight.abstracts.OrderItem;
import com.pluralsight.orderItems.Drink;
import com.pluralsight.orderItems.GarlicKnots;
import com.pluralsight.orderItems.Pizza;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> orderItems;
    private LocalDateTime orderTime;

    // Constructor
    public Order() {
        this.orderItems = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    // Adds/ Removes Item from orderItems List
    public void addItem(OrderItem item) {    orderItems.add(item);    }
    public void removeItem(OrderItem item) {    orderItems.remove(item);    }

    // Returns Total Order Price
    public double getTotalPrice() {
        double total = 0;
        for (OrderItem i : orderItems) {
            total += i.getPrice();
        }
        return total;
    }

    // Determines If Order is Valid
    public boolean isValidOrder(){
        boolean pizzaOrdered = false;
        boolean drinkOrKnotsOrdered = false;

        for (OrderItem i : orderItems) {
            if (i instanceof Pizza) {    pizzaOrdered = true;    }
            if (i instanceof Drink || i instanceof GarlicKnots) {    drinkOrKnotsOrdered = true;    }
        }
        return pizzaOrdered || drinkOrKnotsOrdered;
    }

    // Returns Formatted Receipt File Name
    public String getReceiptFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        return orderTime.format(formatter)+ ".txt";
    }

    // Return Full Order Summary
    public String getOrderSummary(){
        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("************* Order Summary *************\n");
        orderSummary.append("Date: ").append(orderTime).append("\n");
        orderSummary.append("-----------------------------------------\n");

        if (orderItems.isEmpty()) {
            orderSummary.append("No Items Ordered.");
        } else {
            for (OrderItem i : orderItems){
                orderSummary.append(i.getDescription()).append("\n");
            }
        }
        orderSummary.append("-----------------------------------------\n");
        orderSummary.append(String.format("Total Price: $%.2f%n", getTotalPrice()));
        orderSummary.append("*****************************************\n");
        return orderSummary.toString();
    }

    //  Getters
    public List<OrderItem> getOrderItems() {    return orderItems;  }
    public LocalDateTime getOrderTime() {   return orderTime;   }
}

package com.pluralsight.main;

import static com.pluralsight.main.Console.promptForInt;

public class MainApp {

    static Order currentOrder = null;

    static void main() {
        homeScreen();
    }

    // Home Screen
    private static void homeScreen() {
        int command = -1;
        while (command != 0) {
            System.out.print("""
                    \n
                    ====== PIZZA-licious ======
                    1) New Order
                    0) Exit
                    ===========================
                    """);
            command = promptForInt("Enter # Choice: ");
            switch (command) {
                case 1 -> {
                    currentOrder = new Order();
                    orderScreen();
                    break;
                }
                case 0 -> {
                    System.out.println("Thank you for choosing PIZZA-licious, Goodbye!");
                    break;
                }
                default -> System.out.println("Invalid command. Please choose from given # choices: ");
            }
        }
    }

    // Order Screen
    private static void orderScreen() {
        int command = -1;
        while (command != 0) {
            System.out.println("\n======= Order Screen =======");
            if (currentOrder.getOrderItems().isEmpty()){
                System.out.println("No items currently in cart.");
            } else {
                for (int i = currentOrder.getOrderItems().size() -1 ; i >= 0 ; i--) {
                    System.out.println(currentOrder.getOrderItems().get(i).getDescription());
                }
            }
            System.out.print("""
                    \n
                    ---------------------------
                    1) Add Pizza
                    2) Add Drink
                    3) Add Garlic Knots
                    4) Checkout
                    0) Cancel Order
                    ===========================
                    """);
            command = promptForInt("Enter # Choice: ");
            switch (command) {
                case 1 -> {
                    addPizza();
                    break;
                }
                case 2 -> {
                    addDrink();
                    break;
                }
                case 3 -> {
                    addGarlicKnots();
                    break;
                }
                case 4 -> {
                    checkOut();
                    break;
                }
                case 0 -> {
                    System.out.println("Order Cancelled. Returning to Home Screen.....");
                    break;
                }
                default -> System.out.println("Invalid command. Please choose from given # choices: ");
            }
        }
    }

    private static void addPizza() {
    }

    private static void addDrink() {
    }

    private static void addGarlicKnots() {
    }

    private static void checkOut() {
    }
}
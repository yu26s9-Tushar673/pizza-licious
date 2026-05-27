package com.pluralsight.main;

import com.pluralsight.enums.CrustType;
import com.pluralsight.enums.DrinkSize;
import com.pluralsight.enums.Size;
import com.pluralsight.fileManager.ReceiptManager;
import com.pluralsight.orderItems.Drink;
import com.pluralsight.orderItems.GarlicKnots;
import com.pluralsight.orderItems.Pizza;
import com.pluralsight.signaturePizzas.*;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.RegularTopping;
import com.pluralsight.toppings.Sauce;

import static com.pluralsight.main.Console.*;

public class MainApp {

    static Order currentOrder = null;

    public static void main(String[] args) {
        homeScreen();
    }

    // Home Screen
    private static void homeScreen() {
        int command = -1;
        while (command != 0) {
            System.out.print("""
                    \n
                    ============== PIZZA-licious ===============
                    1) New Order
                    0) Exit
                    ============================================
                    """);
            command = promptForInt("Enter # Choice: ");
            switch (command) {
                case 1 -> {
                    currentOrder = new Order();
                    orderScreen();
                }
                case 0 -> System.out.println("Thank you for choosing PIZZA-licious, Goodbye!");
                default -> System.out.println("Invalid command. Please choose from given # choices: ");
            }
        }
    }

    // Order Screen
    private static void orderScreen() {
        int command = -1;
        while (command != 0) {
            System.out.println("\n=============== Order Screen ===============");
            if (currentOrder.getOrderItems().isEmpty()){
                System.out.println("No items currently in cart.");
            } else {
                System.out.println("Current Cart: ");
                for (int i = currentOrder.getOrderItems().size() -1 ; i >= 0 ; i--) {
                    System.out.println(currentOrder.getOrderItems().get(i).getDescription());
                }
            }
            System.out.print("""
                    --------------------------------------------
                    1) Add Pizza
                    2) Add Drink
                    3) Add Garlic Knots
                    4) Add Signature Pizza
                    5) Checkout
                    0) Cancel Order
                    ============================================
                    """);
            command = promptForInt("Enter # Choice: ");
            switch (command) {
                case 1 -> addPizza();
                case 2 -> addDrink();
                case 3 -> addGarlicKnots();
                case 4 -> addSignaturePizza();
                case 5 -> {
                    checkOut();
                    return;
                }
                case 0 -> {
                    currentOrder = null;
                    System.out.println("Order Cancelled. Returning to Home Screen.....");
                    return;
                }
                default -> System.out.println("Invalid command. Please choose from given # choices: ");
            }
        }
    }

    private static void addSignaturePizza() {
        System.out.println("\n============= Signature Pies =============");
        System.out.println("""
                1) Margherita
                2) Veggie
                3) Meat Lovers
                4) Bbq Chicken
                5) Buffalo Chicken
                0) Cancel
                """);

        int choice = promptForInt("Choose Signature Pizza #: ");
        Pizza sigPizza = null;
        switch (choice){
            case 1 -> sigPizza = new MargheritaPizza();
            case 2 -> sigPizza = new VeggiePizza();
            case 3 -> sigPizza = new MeatLovers();
            case 4 -> sigPizza = new BbqChicken();
            case 5 -> sigPizza = new BuffaloChicken();
            case 0 -> { return; }
            default -> {
                System.out.println("Invalid Choice. Returning to Order Screen...");
                return;
            }
        }
        currentOrder.addItem(sigPizza);
        System.out.printf("%nSignature Pizza Added! Price: %.2f%n", sigPizza.getPrice());

    }

    // Add a Pizza to Current Order
    private static void addPizza() {
        System.out.println("\n============= Build Your Pizza =============");

        // Pick Pizza Size
        System.out.print("""
                Pizza Sizes:
                1) Personal 8"  - $8.50
                2) Medium 12"   - $12.00
                3) Large 16"    - $16.50
                --------------------------------------------
                """);
        Size size = switch (promptForInt("Select Pizza Size: ")){
            case 1 -> Size.PERSONAL;
            case 2 -> Size.MEDIUM;
            case 3 -> Size.LARGE;
            default -> throw new IllegalStateException("Invalid choice. Please choose from given # choices: " + promptForInt("Select Pizza Size: "));
        };

        // Pick Crust Type
        System.out.print("""
                
                Crust Types:
                1) Thin
                2) Regular
                3) Thick
                4) Cauliflower
                --------------------------------------------
                """);
        CrustType crust = switch (promptForInt("Select Crust Type: ")){
            case 1 -> CrustType.THIN;
            case 2 -> CrustType.REGULAR;
            case 3 -> CrustType.THICK;
            case 4 -> CrustType.CAULIFLOWER;
            default -> throw new IllegalStateException("Invalid choice. Please choose from given # choices: " + promptForInt("Select Crust Type: "));
        };

        // Stuffed Crust?
        boolean stuffedCrust = promptForYesNo("""
               
               Would you like Stuffed Crust?
               - Personal + $1.00
               - Medium   + $1.50
               - Large    + $2.00
               --------------------------------------------
               """);

        // Create Pizza
        Pizza pizza = new Pizza(size, crust, stuffedCrust);

        // Add Meat Toppings
        System.out.println("\n----------------------------- Meats -----------------------------");
        System.out.println("""
                Charge Per Meat: Personal +$1.00 | Medium +$2.00 | Large +$3.00
                Options:
                1) Pepperoni
                2) Sausage
                3) Ham
                4) Bacon
                5) Chicken
                6) Meatball
                0) Done
                Extra Meat Charge: Personal +$0.50 | Medium +$1.00 | Large +$1.50
                """);
        addMeatToppings(pizza, size);

        // Add Cheese Toppings
        System.out.println("\n----------------------------- Cheeses -----------------------------");
        System.out.println("""
                Charge Per Cheese: Personal +$0.75 | Medium +$1.50 | Large +$2.25
                Options:
                1) Mozzarella
                2) Parmesan
                3) Ricotta
                4) Goat Cheese
                5) Buffalo
                0) Done
                Extra Cheese Charge: Personal +$0.30 | Medium +$0.60 | Large +$0.90
                """);
        addCheeseToppings(pizza, size);

        // Add Regular Toppings
        System.out.println("\n------------------- Regular Toppings (Free) -------------------");
        System.out.println("""
                1) Onions
                2) Mushrooms
                3) Bell peppers
                4) Olives
                5) Tomatoes
                6) Spinach
                7) Basil
                8) Pineapple
                9) Anchovies
                0) Done
                """);
        addRegularToppings(pizza, size);

        // Add Sauce Toppings
        System.out.println("\n----------------------- Sauces (Free) -----------------------");
        System.out.println("""
                1) Marinara
                2) Alfredo
                3) Pesto
                4) Bbq
                5) Buffalo
                6) Olive oil
                0) Done
                """);
        addSauceToppings(pizza, size);

        currentOrder.addItem(pizza);
        System.out.printf("%nPizza Added! Price: %.2f%n", pizza.getPrice());
    }

    private static void addMeatToppings(Pizza pizza, Size size) {
        String [] meats = {"Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball"};
        int choice;
        while ((choice = promptForInt("Select Meat Choice or enter 0 if done: ")) != 0){
            if (choice >= 1 && choice <= meats.length) {
                boolean wantExtra = promptForYesNo("Extra " + meats[choice - 1] + " ?");
                pizza.addToppings(new Meat(meats[choice - 1], wantExtra));
                System.out.println(meats[choice - 1] + " added!");
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }

    private static void addCheeseToppings(Pizza pizza, Size size) {
        String [] cheeses = {"Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo"};
        int choice;
        while ((choice = promptForInt("Select Cheese Choice or enter 0 if done: ")) != 0){
            if (choice >= 1 && choice <= cheeses.length) {
                boolean wantExtra = promptForYesNo("Extra " + cheeses[choice - 1] + " ?");
                pizza.addToppings(new Cheese(cheeses[choice - 1], wantExtra));
                System.out.println(cheeses[choice - 1] + " added!");
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }

    private static void addRegularToppings(Pizza pizza, Size size) {
        String [] toppings = {"Onions", "Mushrooms", "Bell Peppers", "Olives",
                "Tomatoes", "Spinach", "Basil", "Pineapple", "Anchovies"};
        int choice;
        while ((choice = promptForInt("Select Topping Choice or enter 0 if done: ")) != 0){
            if (choice >= 1 && choice <= toppings.length) {
                boolean wantExtra = promptForYesNo("Extra " + toppings[choice - 1] + " ?");
                pizza.addToppings(new RegularTopping(toppings[choice - 1], wantExtra));
                System.out.println(toppings[choice - 1] + " added!");
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }

    private static void addSauceToppings(Pizza pizza, Size size) {
        String [] sauces = {"Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive Oil"};
        int choice;
        while ((choice = promptForInt("Select Sauce Choice or enter 0 if done: ")) != 0){
            if (choice >= 1 && choice <= sauces.length) {
                boolean wantExtra = promptForYesNo("Extra " + sauces[choice - 1] + " ?");
                pizza.addToppings(new Sauce(sauces[choice - 1], wantExtra));
                System.out.println(sauces[choice - 1] + " added!");
            } else {
                System.out.println("Invalid Choice.");
            }
        }
    }

    // Add a Drink to Current Order
    private static void addDrink() {
        System.out.println("============= Add Drink =============");
        System.out.println("""
                Drink Sizes:
                1) Small  - $2.00
                2) Medium - $2.50
                3) Large  - $3.00
                --------------------------------------
                """);
        DrinkSize size = switch (promptForInt("Enter size Choice #: ")) {
          case 1 -> DrinkSize.SMALL;
          case 2 -> DrinkSize.MEDIUM;
          case 3 -> DrinkSize.LARGE;
          default -> throw new IllegalStateException("Invalid: " + promptForInt("Enter size Choice #: "));
        };
        System.out.println("""
                Flavors:
                - Coke
                - Diet Coke
                - Sprite
                - Lemonade
                - Water
                - Orange Juice
                """);
        String flavor = promptForString("Enter Drink Flavor: ");
        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.printf("%nDrink Added! Price: $%.2f%n", drink.getPrice());
    }

    // Add Garlic Knots to Current Order
    private static void addGarlicKnots() {
        System.out.println("\n============ Add Garlic Knots ============");
        System.out.println("Garlic Knots - $1.50 per order");
        int quantity = promptForInt("How many order of Garlic Knots would you like?");

        GarlicKnots garlicKnots = new GarlicKnots(quantity);
        currentOrder.addItem(garlicKnots);
        System.out.printf("%nGarlic Knots Added! Price: $%.2f%n", garlicKnots.getPrice());
    }

    // Checkout Current Order
    private static void checkOut() {
        System.out.println("\n============== Checkout ==============");

        if (!currentOrder.isValidOrder()) {
            System.out.println("Invalid Order! You must add at " +
                    "least one order of Pizza, Drink, or Garlic Knots");
            return;
        }
        System.out.println(currentOrder.getOrderSummary());
        System.out.println("""
                1) Confirm Order
                0) Cancel Order
                """);
        int choice = promptForInt("Enter Choice: ");
            if (choice == 1) {
                ReceiptManager.saveReceipt(currentOrder);
            } else {
                System.out.println("Order Cancelled. Returning to Home Screen...");
            }
        currentOrder = null;
    }
}
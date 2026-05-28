# PIZZA-Licious

## Description
A Java Command-Line Interface application that acts as a checkout system for a custom pizza shop (Pizza-licious). 
Customers can customize their pizza order, add drinks or garlic knots, and recieve a order receipt with is saved as a txt file to a Receipts folder.

## Table of Contents
- [Technologies Used] (#technologies-used)
- [Features] (#features)
- [How To Run] (#how-to-run)
- [How To Use] (#how-to-use)
- [Class Diagrams] (#class-diagrams)
- [Screenshots] (#screenshots)
- [Future Improvements] (#future-improvements)

## Technologies Used
- Java 17+
- IntelliJ IDEA

## Features
- Create a new order and add multiple order items.
- Customize a Pizza:
  - Choose size (Personal 8", Medium 12", Large 16").
  - Choose Crust Type (Thin, Regular, Thick, Cauliflower).
  - Add Premium Topping at and extra charge (Meats and Cheeses).
  - Add Regular Toppings, sauces, and sides for free.
  - Option to have a Stuffed Crust at an extra charge
- Order signature pizzas (Bbq Chicken, Buffalo Chicken, Veggie, Margherita, Meat Lovers).
- Add Drinks (Small, Medium, Large) with flavor selection.
- Add Garlic Knot order(s).
- View the current total on the Order Screen
- Checkout with the full order summary and price breakdown
- Receipt saved once order is confirms to a Receipts folder with date and time formatted as the txt file name.

## How To Run
  1. Clone the repository:

    - Open Command Line Interface (Git Bash or Terminal).
    - cd to desired directory.
    - Run: git clone https://github.com/yu26s9-Tushar673/pizza-licious.git
  2. Open the project in IntelliJ IDEA.
  3. Run the MainApp.java found in --> src/main/java/com/pluralsight/main/MainApp.java

## How To Use
1. **Home Screen**
   - Start a New Order or exit the application.
2. **Order Screen**
   - Add a custom/signature pizza, drink, or Garlic Knots to your order.
   - View current Order Summary.
   - Checkout or Cancel Order.
3. **Add Custom Pizza Screen**
   - Select Size, crust type, and stuffed crust option.
   - Add meats, cheeses, regular toppings, sauces and sides.
4. **Add Signature Pizza Screen**
   - Select from given Signature Pies options or enter 0 to return to order screen.
   - Add or remove topping to selected option, or enter 0 to leave as is.
5. **Checkout Screen**
   - Review full order with itemized prices.
   - Confirm to save receipt and return to home screen.
   - Cancel to delete the order and return to home screen.

## Class Diagram
Original:

<img width="345" height="361" alt="PIZZA-licious-UML" src="https://github.com/user-attachments/assets/9d5ec824-3f59-42f0-a706-68fa1d88249a" />


Updated:

<img width="380" height="328" alt="Updated-PIZZA-licious-UML" src="https://github.com/user-attachments/assets/ec08ef70-f57d-4939-92ab-9ce8756da12b" />


## Screenshots
- Home Screen:

  <img width="458" height="150" alt="image" src="https://github.com/user-attachments/assets/3ddb87eb-9246-4c87-a9fb-b09ee5472b3f" />

- Order Screen:

  <img width="449" height="336" alt="image" src="https://github.com/user-attachments/assets/5928c316-200d-4943-8e44-3a7fc2789e7a" />

- Add Custom Pizza Screen:

  <img width="463" height="659" alt="image" src="https://github.com/user-attachments/assets/5f1475cf-1847-4205-887e-443abeea0c95" />
  <img width="683" height="722" alt="image" src="https://github.com/user-attachments/assets/4ea19eac-3b99-4b81-bb84-ccae942f8c7a" />
  <img width="645" height="722" alt="image" src="https://github.com/user-attachments/assets/76a0d5b5-6902-4c87-a9a0-59e5f40528fb" />
  <img width="609" height="225" alt="image" src="https://github.com/user-attachments/assets/0b22b86c-688d-445b-a11d-fbccedb888ab" />


- Add Signature Pizza Screen:

  <img width="426" height="313" alt="image" src="https://github.com/user-attachments/assets/5e4066b4-43ed-4bb6-b61f-0aea47e20de0" />

- Checkout Screen

  <img width="523" height="431" alt="image" src="https://github.com/user-attachments/assets/a36efb12-25aa-4b57-a0fb-7a618719a548" />

## Future Improvements
- Add Combo order options that give discounts
- Add a GUI
   


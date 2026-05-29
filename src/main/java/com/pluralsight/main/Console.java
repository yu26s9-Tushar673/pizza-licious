package com.pluralsight.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for an integer.
     * @param prompt to display the user
     * @return the int the user selected.
     */
    public static int promptForInt(String prompt) {
        System.out.print(prompt);
        int result;

        while(true){
            try {
                result =  scanner.nextInt();
                scanner.nextLine();
                return result;
            }
            catch (InputMismatchException e){
                System.out.print("Invalid selection, please enter a number: ");
            }
            scanner.nextLine(); // Buffer handling
        }
    }

    /**
     * Prompts the user for a string.
     * @param prompt to display the user
     * @return the string the user selected.
     */
    public static String promptForString(String prompt) {
        System.out.print(prompt);
        while (true)
        {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty())
                {   return "";    }
                return input;
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }

    /**
     * Prompts the user for a Yes or No which is returned as a boolean.
     * @param prompt to display the user
     * @return the boolean
     */
    public static boolean promptForYesNo(String prompt) {
        System.out.print(prompt + " (Yes/No): ");
        while (true) {
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y"))
            {   return true;    }
            else if (userInput.equalsIgnoreCase("no") || userInput.equalsIgnoreCase("n"))
            {   return false;   }
            System.out.print("Invalid Input! Please enter yes or no: ");
        }
    }
}

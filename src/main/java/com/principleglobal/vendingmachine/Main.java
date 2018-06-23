package com.principleglobal.vendingmachine;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static final int OPTIMAL_CHANGE = 1;
    private static final int CHANGE = 2;
    private static final int EXIT = 3;
    private static int option = EXIT;

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        showOptionMenu();
        System.out.println("Enter cents: ");
        int cents = scanner.nextInt();
        if (option == OPTIMAL_CHANGE)
            System.out.println(vendingMachine.getOptimalChangeFor(cents));
        else if (option == CHANGE)
            System.out.println(vendingMachine.getChangeFor(cents));
    }

    private static void showOptionMenu() {
        boolean isOptionValid = false;
        while (!isOptionValid) {
            System.out.println("Please enter a valid option");
            System.out.println("1. getOptimalChange ");
            System.out.println("2. getChange ");
            System.out.println("3. Exit");
            option = scanner.nextInt();
            if (option == EXIT)
                System.exit(0);
            isOptionValid = (option == OPTIMAL_CHANGE || option == CHANGE);
        }
    }
}

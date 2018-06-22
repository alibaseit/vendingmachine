package com.principleglobal.vendingmachine;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        int option = showOptionMenu();
        System.out.println("Enter cents: ");
        int cents = scanner.nextInt();
        if (option == 1)
            System.out.println(vendingMachine.getOptimalChangeFor(cents));
        else if (option == 2)
            System.out.println(vendingMachine.getChangeFor(cents));
    }

    private static int showOptionMenu() {
        int option = 3;
        boolean isOptionValid = false;
        while (!isOptionValid) {
            System.out.println("Please enter a valid option");
            System.out.println("Enter option: ");
            System.out.println("1. getOptimalChange ");
            System.out.println("2. getChange ");
            System.out.println("3. Exit");
            option = scanner.nextInt();
            if (option == 3)
                System.exit(0);
            isOptionValid = (option == 1 || option == 2);
        }
        return option;
    }
}

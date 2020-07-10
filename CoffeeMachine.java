package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER = 200;    // ml of water need to make a cup
    private static final int MILK = 50;      // ml of milk needed for a cup
    private static final int BEANS = 15;     // g of coffee beans

    private static int totalWater;
    private static int totalMilk;
    private static int totalBeans;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fillMachine();
        int cups = calculateCups();
        askUser(cups);
    }

    // get the amounts of ingredients are in the machine
    private static void fillMachine() {
        System.out.println("Write how many ml of water the coffee machine has:");
        totalWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        totalMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        totalBeans = scanner.nextInt();
    }

    // calculate the how many cups we can make based on how much of each ingredient there is
    private static int calculateCups() {
        int cupsWater = totalWater / WATER;
        int cupsMilk  = totalMilk / MILK;
        int cupsBeans = totalBeans / BEANS;

        return Math.min(cupsWater, Math.min(cupsMilk, cupsBeans));
    }

    // ask the user how many cups they want, and inform them if we can or cannot fulfill it
    private static void askUser(int cups) {
        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        if (cupsNeeded > cups) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", cups);
        } else {
            System.out.print("Yes, I can make that amount of coffee");
            if (cupsNeeded < cups) {
                System.out.printf(" (and even %d more than that)", cups - cupsNeeded);
            }
            System.out.println();
        }
    }
}

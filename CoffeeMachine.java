package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int machineWater;
    private static int machineMilk;
    private static int machineBeans;
    private static int machineCups;
    private static int machineMoney;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupMachine();
        printMachineStatus();
        System.out.println();
        askAction();
        System.out.println();
        printMachineStatus();
    }

    // initial state of the machine
    private static void setupMachine() {
        machineWater = 400;
        machineMilk  = 540;
        machineBeans = 120;
        machineCups  = 9;
        machineMoney = 550;
    }

    private static void printMachineStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(machineWater + " of water");
        System.out.println(machineMilk + " of milk");
        System.out.println(machineBeans + " of coffee beans");
        System.out.println(machineCups + " of disposable cups");
        System.out.println(machineMoney + " of money");
    }

    // get the amounts of ingredients are in the machine
    private static void askAction() {
        String action;
        boolean actionTaken = false;

        while(!actionTaken) {
            System.out.println("Write action (buy, fill, take):");
            action = scanner.next();
            switch (action) {
                case "buy":
                    buyDrink();
                    actionTaken = true;
                    break;
                case "fill":
                    fillMachine();
                    actionTaken = true;
                    break;
                case "take":
                    takeMoney();
                    actionTaken = true;
                    break;
                default:
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + machineMoney);
        machineMoney = 0;
    }

    private static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add:");
        machineWater += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        machineMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        machineBeans += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        machineCups += scanner.nextInt();
    }

    private static void buyDrink() {
        boolean drinkBought = false;

        while (!drinkBought) {
            machineCups--;
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            switch (scanner.nextInt()) {
                case 1:
                    machineWater -= 250;
                    machineBeans -= 16;
                    machineMoney += 4;
                    drinkBought = true;
                    break;
                case 2:
                    machineWater -= 350;
                    machineMilk -= 75;
                    machineBeans -= 20;
                    machineMoney += 7;
                    drinkBought = true;
                    break;
                case 3:
                    machineWater -= 200;
                    machineMilk -= 100;
                    machineBeans -= 12;
                    machineMoney += 6;
                    drinkBought = true;
                    break;
                default:
                    scanner.nextLine();
                    break;
            }
        }
    }

    // calculate the how many cups we can make based on how much of each ingredient there is
//    private static int calculateCups() {
//        int cupsWater = machineWater / WATER;
//        int cupsMilk  = machineMilk / MILK;
//        int cupsBeans = machineBeans / BEANS;
//
//        return Math.min(cupsWater, Math.min(cupsMilk, cupsBeans));
//    }

    // ask the user how many cups they want, and inform them if we can or cannot fulfill it
//    private static void askUser(int cups) {
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsNeeded = scanner.nextInt();
//
//        if (cupsNeeded > cups) {
//            System.out.printf("No, I can make only %d cup(s) of coffee\n", cups);
//        } else {
//            System.out.print("Yes, I can make that amount of coffee");
//            if (cupsNeeded < cups) {
//                System.out.printf(" (and even %d more than that)", cups - cupsNeeded);
//            }
//            System.out.println();
//        }
//    }
}

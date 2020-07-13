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
        askAction();
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
        System.out.println("$" + machineMoney + " of money");
        System.out.println();
    }

    // loop to get the action the user wants to do
    private static void askAction() {
        String action = "";

        while(!action.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next().toLowerCase();
            System.out.println();
            switch (action) {
                case "buy":
                    buyDrink();
                    break;
                case "fill":
                    fillMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printMachineStatus();
                    break;
                default:
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + machineMoney);
        System.out.println();
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

        System.out.println();
    }

    private static void buyDrink() {
        boolean drinkBought = false;

        while (!drinkBought) {
            drinkBought = true;
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            switch (scanner.next().toLowerCase()) {
                case "1":
                    drinkBought = new Drink.Espresso().makeDrink();
                    break;
                case "2":
//                    drinkBought =
                            new Drink.Latte().makeDrink();
                    break;
                case "3":
//                    drinkBought = new Drink.Cappuccino().makeDrink();
                    new Drink.Cappuccino().makeDrink();
                    break;
                case "back":
//                    drinkBought = true;
                    break;
                default:
                    drinkBought = false;
                    scanner.nextLine();
                    break;
            }
        }
    }

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

    private static class Drink {
        private static int water;
        private static int milk;
        private static int beans;
        private static int cost;

        public boolean makeDrink() {
            boolean drinkMade = checkIngredients();

            if (drinkMade) {
                System.out.println("I have enough resources, making you a coffee!");
                machineWater -= water;
                machineMilk  -= milk;
                machineBeans -= beans;
                machineMoney += cost;
                machineCups--;
            }

            System.out.println();
            return drinkMade;
        }

        private boolean checkIngredients() {
            boolean made = true;

            if (water > machineWater) {
                System.out.println("Sorry, not enough water!");
                made = false;
            }

            if (milk > machineMilk) {
                System.out.println("Sorry, not enough milk!");
                made = false;
            }

            if (beans > machineBeans) {
                System.out.println("Sorry, not enough coffee beans!");
                made = false;
            }

            if (machineCups == 0) {
                System.out.println("Sorry, not enough cups!");
                made = false;
            }

            return made;
        }

        private static class Espresso extends Drink {
            Espresso() {
                water = 250;
                milk  = 0;
                beans = 16;
                cost  = 4;
            }
        }

        private static class Latte extends Drink {
            Latte() {
                water = 350;
                milk  = 75;
                beans = 20;
                cost  = 7;
            }
        }

        private static class Cappuccino extends Drink {
            Cappuccino() {
                water = 200;
                milk  = 100;
                beans = 12;
                cost  = 6;
            }
        }
    }
}

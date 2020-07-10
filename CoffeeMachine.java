package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        int WATER = 200;    // ml of water need to make a cup
        int MILK = 50;      // ml of milk needed for a cup
        int BEANS = 15;     // g of coffee beans

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", cups * WATER);
        System.out.printf("%d ml of milk\n", cups * MILK);
        System.out.printf("%d g of coffee beans\n", cups * BEANS);
    }
}

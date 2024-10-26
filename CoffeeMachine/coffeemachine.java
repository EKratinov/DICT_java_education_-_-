import java.util.Scanner;

public class coffeemachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int waterNeeded = cups * 200;
        int milkNeeded = cups * 50;
        int coffeeBeansNeeded = cups * 15;

        int possibleCups = Math.min(Math.min(water / 200, milk / 50), coffeeBeans / 15);

        if (possibleCups >= cups) {
            int extraCups = possibleCups - cups;
            if (extraCups > 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }


}


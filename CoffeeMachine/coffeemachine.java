import java.util.Scanner;

public class coffeemachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        // Цикл для повторного выполнения команд
        while (running) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printRemaining();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Try again.");
                    break;
            }
        }
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        if (choice.equals("back")) {
            return; // Возврат к выбору действия
        }

        int waterNeeded = 0, milkNeeded = 0, coffeeNeeded = 0, cost = 0;

        switch (choice) {
            case "1": // Эспрессо
                waterNeeded = 250;
                coffeeNeeded = 16;
                cost = 4;
                break;
            case "2": // Лате
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeNeeded = 20;
                cost = 7;
                break;
            case "3": // Капучино
                waterNeeded = 200;
                milkNeeded = 100;
                coffeeNeeded = 12;
                cost = 6;
                break;
            default:
                System.out.println("Unknown coffee type.");
                return;
        }

        if (checkResources(waterNeeded, milkNeeded, coffeeNeeded)) {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeNeeded;
            disposableCups--;
            money += cost;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();

        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += scanner.nextInt();

        System.out.println("The coffee machine has been refilled.");
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println(money + " of money");
    }

    private static boolean checkResources(int waterNeeded, int milkNeeded, int coffeeNeeded) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans < coffeeNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }
}


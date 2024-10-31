import java.util.Scanner;

public class coffeemachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;
    private String state;
    private Scanner scanner;

    public coffeemachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
        this.state = "choosing action";
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        coffeemachine machine = new coffeemachine();
        machine.run();
    }

    public void run() {
        while (!state.equals("exit")) {
            processInput(scanner.nextLine());
        }
    }

    public void processInput(String input) {
        switch (state) {
            case "choosing action":
                handleAction(input);
                break;
            case "choosing coffee":
                handleCoffeeChoice(input);
                break;
            case "filling machine":
                handleFilling(input);
                break;
        }
    }

    private void handleAction(String input) {
        switch (input) {
            case "buy":
                state = "choosing coffee";
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                state = "filling machine";
                System.out.println("Write how many ml of water you want to add:");
                break;
            case "take":
                System.out.println("I gave you $" + money);
                money = 0;
                break;
            case "remaining":
                printRemaining();
                break;
            case "exit":
                state = "exit";
                break;
            default:
                System.out.println("Unknown command. Try again.");
                break;
        }
    }

    private void handleCoffeeChoice(String input) {
        if (input.equals("back")) {
            state = "choosing action";
            return;
        }

        int waterNeeded = 0, milkNeeded = 0, coffeeNeeded = 0, cost = 0;
        switch (input) {
            case "1": // espresso
                waterNeeded = 250;
                coffeeNeeded = 16;
                cost = 4;
                break;
            case "2": // latte
                waterNeeded = 350;
                milkNeeded = 75;
                coffeeNeeded = 20;
                cost = 7;
                break;
            case "3": // cappuccino
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
        state = "choosing action";
    }

    private void handleFilling(String input) {
        water += Integer.parseInt(input);
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable coffee cups you want to add:");
        disposableCups += Integer.parseInt(scanner.nextLine());
        state = "choosing action";
    }

    private void printRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println(money + " of money");
    }

    private boolean checkResources(int waterNeeded, int milkNeeded, int coffeeNeeded) {
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

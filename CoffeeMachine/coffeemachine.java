import java.util.Scanner;

public class coffeemachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        int water = cups * 200; // 200 мл воды на чашку
        int milk = cups * 50;   // 50 мл молока на чашку
        int coffeeBeans = cups * 15; // 15 г кофе на чашку

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }
}


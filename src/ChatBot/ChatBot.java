package ChatBot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String bot_name = "ChatBot";
        int birth_year = 2024;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is " + bot_name + ".");
        System.out.println("I was created in " + birth_year + ".");
        System.out.println("Please remind me your name.");

        String your_name = scanner.nextLine();
        System.out.println("What a great name you have, " + your_name + "!");
    }
}
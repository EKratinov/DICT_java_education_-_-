package Hangman;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctWord = "java";

        System.out.println("HANGMAN");
        System.out.println("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(correctWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}

package Hangman;
import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        String chosenWord = words[new Random().nextInt(words.length)];

        System.out.println("HANGMAN");
        System.out.println("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(chosenWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}

package Hangman;
import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        String chosenWord = words[new Random().nextInt(words.length)];
        String hint = chosenWord.substring(0, 2) + "-".repeat(chosenWord.length() - 2);

        System.out.println("HANGMAN");
        System.out.println("Guess the word " + hint + ": > ");
        String guess = scanner.nextLine();

        if (guess.equals(chosenWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}

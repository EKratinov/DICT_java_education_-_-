package Hangman;
import java.util.Scanner;
import java.util.Random;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"python", "java", "javascript", "kotlin"};
        String chosenWord = words[new Random().nextInt(words.length)];
        StringBuilder displayWord = new StringBuilder("-".repeat(chosenWord.length()));
        int attempts = 8;

        System.out.println("HANGMAN");

        while (attempts > 0 && displayWord.toString().contains("-")) {
            System.out.println("Current word: " + displayWord);
            System.out.println("Input a letter: > ");
            char letter = scanner.nextLine().charAt(0);

            if (chosenWord.indexOf(letter) >= 0) {
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == letter) {
                        displayWord.setCharAt(i, letter);
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word.");
                attempts--;
            }
        }

        if (displayWord.toString().equals(chosenWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost! The word was " + chosenWord + ".");
        }

        scanner.close();
    }
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    static Scanner userInput = new Scanner(System.in);
    static int topOfRange = 0;
    static int guess;
    static int num;
    static String input;
    static int numberToGuess;
    static ArrayList<Integer> alreadyGuessed = new ArrayList<Integer>();
    static int numberOfGuesses = 0;

    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = userInput.nextLine();
        System.out.printf("Hello %s, let the game begin!\n", name);
        while (topOfRange <= 0) {
            topOfRange = numberChecker("Enter a top number in the range, or 0? ");
        }
        generateRandomNumber(topOfRange);
        while (numberOfGuesses <= 6) {
            guess = numberChecker("Guess? ");
            if (guess > 0) {
                if (guess == numberToGuess) {
                    System.out.println("Yay! You are right!");
                    System.exit(0);
                } else {

                    if (!(alreadyGuessed.contains(num))) {
                        alreadyGuessed.add(num);
                        if (guess < numberToGuess) {
                            System.out.println("Nope. You are low.");
                        } else {
                            System.out.println("Nope. You are high.");
                        }
                    } else {
                        System.out.println("You have already tried this.");
                    }
                }
            }
        }
    }

    static int numberChecker(String message) {
        System.out.print(message);
        input = userInput.next();
        try {
            num = Integer.parseInt(input);
            if (num == 0) {
                System.exit(0);
            } else if (num >= 1) {
                numberOfGuesses++;
                return num;
            } else {
                System.out.println("Nah. ");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Something is wrong with your so-called \"number\"!");
            return 0;
        }
        return 0;
    }

    static void generateRandomNumber(int top) {
        Random x = new Random();
        numberToGuess = x.nextInt(top) + 1;
    }
}
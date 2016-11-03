import java.util.Scanner;

public class Workshop22{
    static Scanner newString = new Scanner(System.in);
    public static void main(String... args) {
        // create a function which prints the input String parameters (can have multiple number of arguments)
        System.out.print("Enter your string: ");
        String myString = newString.nextLine();
        stringParam(myString);
    }
    public static void stringParam(String inputString) {
        inputString = inputString.trim();
        if (inputString.isEmpty()) {
            System.out.println("The string is empty.");
        }
        else {
            System.out.printf("Length of the string is: %d characters \n", inputString.length());
            System.out.printf("First character of the string is: %s\n", inputString.charAt(0));
            System.out.printf("Last character of the string is: %s", inputString.charAt(inputString.length() - 1));
        }
    }
}
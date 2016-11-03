import java.util.Scanner;

public class Workshop19{
    static Scanner newNumber = new Scanner(System.in);
    public static void main(String[] args) {
        // create a function that returns it's input factorial
        System.out.print("Enter an integer: ");
        if (newNumber.hasNextInt()) {
            int inputNumber = newNumber.nextInt();
            System.out.printf("The factorial of %d is %d.", inputNumber, factorial(inputNumber));
        } else {
            System.out.println("Not an integer.");
        }
    }
    public static int factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            int fact = 1;
            for (int i = 1; i <= x; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
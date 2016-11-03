import java.util.Scanner;

public class Fibonacci{
    static Scanner newNumber = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the index of the number: ");
        if (newNumber.hasNextInt()) {
            int inputNumber = newNumber.nextInt();
            System.out.printf("Element number %d of the Fibonacci series is %d.", inputNumber, fib(inputNumber));
        } else {
            System.out.println("Not an integer.");
        }
    }
    public static int fib(int x) {
        if (x < 3) {
            return 1;
        }
        return fib(x -1) + fib(x - 2);
    }
}
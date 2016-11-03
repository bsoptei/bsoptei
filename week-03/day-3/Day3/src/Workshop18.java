import java.util.Scanner;

public class Workshop18{
    static Scanner newNumber = new Scanner(System.in);
    public static void main(String[] args) {
        // write a function that sum all the numbers until the given parameter
        System.out.print("Enter an integer: ");
        if (newNumber.hasNextInt()) {
            int inputNumber = newNumber.nextInt();
            System.out.println("The calculation resulted in: " + addUntil(inputNumber));
        } else {
            System.out.println("Not an integer.");
        }
    }
    public static int addUntil(int x) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}
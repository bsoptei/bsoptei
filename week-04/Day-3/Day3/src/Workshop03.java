import java.util.Scanner;

public class Workshop03 {
    static Scanner userInput = new Scanner(System.in);
    static boolean continueLoop = true;

    public static void main(String[] args) {
        while (continueLoop) {
            Double num;
            System.out.print("INPUT or 0 to end? ");
            String input = userInput.next();
            try {
                num = Double.parseDouble(input);
                if (num == 0) {
                    continueLoop = false;
                } else if (num > Integer.MAX_VALUE) {
                    throw new ArithmeticException();
                } else {
                    System.out.printf("Yum\n");
                    getFirstHalf(input);
                }
            } catch (ArithmeticException e) {
                System.out.printf("Invalid value %s, number too large!\n", e);
            } catch (NumberFormatException e) {
                System.out.printf("Invalid value %s, not a number!\n", e);
            }
        }
        System.out.println("Bye!");
    }

    static void getFirstHalf(String inputString) {
        String firstHalf;
        firstHalf = inputString.substring(0, inputString.length() /2);
        System.out.println(firstHalf);
    }
}
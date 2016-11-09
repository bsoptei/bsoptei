import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Workshop24 {
    static Scanner userInput = new Scanner(System.in);
    static float result;
    static boolean validResult = true;
    static float a, b;
    static boolean loopCalc = true;
    static String[] operation;

    public static void main(String... args) {
        while (loopCalc) {
            System.out.print("Please type in the expression (operator[space]operand[space]operand) : ");
            String mathToDo = userInput.nextLine();
            operation = mathToDo.split(" ");

            if (operation.length == 3) {
                try {
                    a = Float.valueOf(operation[1]);
                    b = Float.valueOf(operation[2]);
                    doCalculation();
                } catch (Exception e) {
                    System.out.println("Sorry, something is wrong with your expression");
                    validResult = false;
                }
                if (validResult) {
                    System.out.printf("The result is %f.", result);
                }
            } else {
                System.out.println("Sorry, this program can operate with 3 arguments.");
            }
            System.out.print("Would you like another calculation?  If so, type \"Y\": ");
            String doYoWantNew = userInput.nextLine();
            if (!(doYoWantNew.equalsIgnoreCase("Y"))) {
                loopCalc = false;
            }
        }
    }

    static void doCalculation() {
        switch (operation[0]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / b;
                } else {
                    System.out.println("You cannot do division by zero.");
                    validResult = false;
                }
                break;
            case "%":
                if (b != 0) {
                    result = a % b;
                } else {
                    System.out.println("You cannot do modulo by zero.");
                    validResult = false;
                }
                break;
            default:
                validResult = false;
                System.out.printf("Sorry, cannot process %s as an operation", operation[0]);
        }
    }
}
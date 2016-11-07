import java.util.Scanner;

public class Workshop24{
    static Scanner userInput = new Scanner(System.in);
    static float result;
    static boolean validResult = true;

    public static void main(String... args){
        System.out.print("Please type in the expression: ");
        String mathToDo = userInput.nextLine();
        String [] operation = mathToDo.split(" ");
        if (operation.length == 3) {
            float a = Float.valueOf(operation[1]);
            float b = Float.valueOf(operation[2]);

        switch (operation[0]) {
            case "+": result = a + b;
                break;
            case "-": result = a - b;
                break;
            case "*": result = a * b;
                break;
            case "/": result = a / b;
                break;
            case "%": result = a % b;
                break;
            default: validResult = false;
                System.out.printf("Sorry, cannot process %s as an operation", operation[0]);
        }
            if (validResult) {
                System.out.printf("The result is %f.", result);
            }
        } else {
            System.out.println("Sorry, this program can operate with 3 arguments.");
        }
    }
}
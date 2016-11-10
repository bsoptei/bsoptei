import java.util.*;

public class Workshop07 {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int age;
        String prompt = "Enter any number, 0 to exit?";

        System.out.println(prompt);
        while (userInput.hasNextInt()) {
            age = userInput.nextInt();
            if (age == 0) {
                break;
            } else {
                try {
                    System.out.println("Before checking");
                    myMethod(age);
                    System.out.println("After checking");
                } catch (Exception ex) {
                    System.out.println("Sevens are cannibals");
                }
            }
        }
    }

    static void myMethod(int testnum) throws Exception {
        if (testnum == 7) {
            throw new Exception();
        }
    }

}
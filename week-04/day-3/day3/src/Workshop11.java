import java.util.*;

public class Workshop11 {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int age;
        String prompt = "Enter any number, 0 to exit?";

        System.out.println(prompt);
        age = userInput.nextInt();

            try {
                System.out.println("Before checking");
                myMethod(age);
                System.out.println("After checking");
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
    }

    static void myMethod(int testNum) throws Exception {
        if (testNum == 7) {
            throw new Exception("Sevens are cannibals");
        }
        if (testNum == 9) {
            throw new Exception("Exception: Nothing but bones");
        }
    }

}
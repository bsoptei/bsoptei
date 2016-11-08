import java.util.Scanner;

public class Workshop22{
    public static void main(String... args) {
        // create a function which prints the input String parameters (can have multiple number of arguments)

        stringParam("one", "two", "three");
    }
    public static void stringParam(String... inputString) {
        for (String s : inputString) {
            System.out.println(s);
        }
    }
}
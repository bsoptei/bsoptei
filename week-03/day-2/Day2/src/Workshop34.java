public class Workshop34 {
    public static void main(String[] args) {
        // Write a program that prints the numbers from 1 to 100.
        // But for multiples of three print "Fizz" instead of the number
        // and for the multiples of five print "Buzz".
        // For numbers which are multiples of both three and five print "FizzBuzz".
        for (int i = 1; i <= 100; i++) {
            String test = "";
            test += (i % 3) == 0 ? "Fizz" : "";
            test += (i % 5) == 0 ? "Buzz" : "";
            System.out.println(!test.isEmpty() ? test : i);
        }

    }
}
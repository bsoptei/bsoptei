public class Workshop19{
    public static void main(String[] args) {
        // create a function that returns it's input factorial

        System.out.println(factorial(10));
    }
    public static int factorial(int x) {
        if (x == 0) {
            return 1;
        }
        else {
            int fact = 1;
            for (int i = 1; i <= x; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}
public class Workshop21{
    public static void main(String[] args) {
        // create a function that returns it's input factorial

        System.out.println(factorial(3));
    }
    public static int factorial(int x) {
        if (x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }
}
public class Fibonacci{
    public static void main(String[] args) {
        // create a function that returns it's input factorial

        System.out.println(fib(40));
    }
    public static int fib(int x) {
        if (x < 3) {
            return 1;
        }
        return fib(x -1) + fib(x - 2);
    }
}
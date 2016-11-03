public class Workshop18{
    public static void main(String[] args) {
        // write a function that sum all the numbers until the given parameter

        System.out.println(addUntil(10));
    }
    public static int addUntil(int x) {
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}
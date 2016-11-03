public class Workshop07{
    public static void main(String[] args) {
        // What's the problem with this code fragment? Fix it!
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; i++) {
            array[i] = (int)Math.pow(i, 2);
            System.out.println(array[i]);
        }
    }
}
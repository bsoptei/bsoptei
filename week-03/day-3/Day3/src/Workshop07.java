public class Workshop07{
    public static void main(String[] args) {
        // What's the problem with this code fragment? Fix it!
        int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 10; i++) {
            array[i] = i * i;
            System.out.println(array[i]);
        }
    }
}
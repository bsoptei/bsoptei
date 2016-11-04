import java.util.Arrays;

public class Workshop23{
    public static void main(String... args) {
        // Create a function with the same name as PrintValues which can print integers (int) to the output
        PrintValues(new String[] { "first", "second", "third"});
        System.out.println();

        PrintValues(new int[] { 3, 4, 5, 6, 7});
    }
    public static void PrintValues(String[] values){
        System.out.println(Arrays.toString(values));
    }
    public static void PrintValues(int[] values){
        System.out.println(Arrays.toString(values));
    }
}
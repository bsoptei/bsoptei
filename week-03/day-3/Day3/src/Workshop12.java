import java.util.Arrays;

public class Workshop12{
    public static void main(String[] args) {
        // Swap the first element of the array
        // Expected output: third second first
        String[] abc = new String[] { "first", "second", "third" };
        String temporary = abc[2];
        abc[2] = abc[0];
        abc[0] = temporary;
        System.out.println(Arrays.toString(abc));
    }
}
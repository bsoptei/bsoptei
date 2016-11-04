import java.util.Arrays;

public class Workshop09{
    public static void main(String[] args) {
        int[] ag = new int[] {3, 4, 5, 6, 7};
        // please double all the elements of the list
        for (int y = 0; y < ag.length; y++) {
            ag[y] *= 2;
        }
        System.out.println(Arrays.toString(ag));
    }
}
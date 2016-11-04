import java.util.*;

public class Workshop14{
    public static void main(String[] args) {
        // Reverse the order of ah
        int[] ah = new int[] {3, 4, 5, 6, 7};
        ArrayList<Integer> ahNew = new ArrayList<Integer>();
        for (int x: ah) {
            ahNew.add(x);
        }
        Collections.sort(ahNew, Collections.reverseOrder());
        System.out.println(ahNew);
    }
}
import java.util.*;

public class Workshop14{
    public static void main(String[] args) {
        // Reverse the order of ah
        Integer[] ah = new Integer[] {3, 4, 5, 6, 7};
        ArrayList<Integer> ahNew = new ArrayList<Integer>(Arrays.asList(ah));
        Collections.sort(ahNew, Collections.reverseOrder());
        System.out.println(ahNew);
    }
}
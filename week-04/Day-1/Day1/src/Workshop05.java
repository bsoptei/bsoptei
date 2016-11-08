import java.util.*;

public class Workshop05{
    public static void main(String... args){
        ArrayList<Integer> numList = new ArrayList<Integer>(Arrays.asList(12, 1, 532, 23, 0, 7, 54, 32));
        // Copy every element of "numList" to an Array
        Integer[] numListCopy = numList.toArray(new Integer[0]);
//        System.arraycopy(numList.toArray(),0, numListCopy, 0, 8);
        for (Integer element: numListCopy) {
            System.out.println(element);
        }
    }
}

import java.util.*;

public class Workshop15{
    public static void main(String... args){
        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7 ));
        // Add "a" to every string in al. Use a for(each) loop
        ArrayList<String> alString = new ArrayList<String>();
        for (int number: al) alString.add(Integer.toString(number) + "a");
        System.out.println(alString);

    }
}